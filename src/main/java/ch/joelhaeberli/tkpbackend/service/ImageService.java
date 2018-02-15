package ch.joelhaeberli.tkpbackend.service;

import ch.joelhaeberli.tkpbackend.common.general.GeneralErrors;
import ch.joelhaeberli.tkpbackend.common.pictureutil.PictureHandler;
import ch.joelhaeberli.tkpbackend.domain.picture.Picture;
import ch.joelhaeberli.tkpbackend.domain.picture.PictureRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static ch.joelhaeberli.tkpbackend.common.general.GeneralErrors.COULD_NOT_DELETE_PICTURE;
import static ch.joelhaeberli.tkpbackend.common.general.GeneralErrors.COULD_NOT_LOAD_PICTURE;
import static ch.joelhaeberli.tkpbackend.common.general.GeneralErrors.COULD_NOT_SAVE_PICTURE;
import static ch.joelhaeberli.tkpbackend.common.general.GeneralSuccess.DELETING_PICTURE_SUCCESSFUL;
import static ch.joelhaeberli.tkpbackend.common.general.GeneralSuccess.PICTURE_SAVED_SUCCESSFUL;

@Service
public class ImageService {

    Logger logger = LoggerFactory.getLogger(ImageService.class);

    private static final int PAGE_SIZE = 10;

    @Autowired
    PictureRepo pictureRepo;

    public HashMap<Picture, byte[]> getPictures(long lastIndex) {

        HashMap<Picture, byte[]> picturesAndRaws = new HashMap<>();
        List<Picture> pictures = pictureRepo.getAllByIdOrderByIdDesc();
        pictures.forEach(picture -> {
            int picCount = 0;
            if (picCount <= PAGE_SIZE && picture.getId() > lastIndex) {
                picturesAndRaws.put(picture, PictureHandler.getPictureAsByteArrayFromDisk(picture.getPictureName()));
                picCount++;
            }
        });

        return picturesAndRaws;
    }

    public byte[] loadImage(String uuid) {

        Picture p = pictureRepo.getByPictureNameEquals(uuid);
        if (p != null) {

            return PictureHandler.getPictureAsByteArrayFromDisk(uuid);
        }
        logger.info(COULD_NOT_LOAD_PICTURE);
        return null;
    }

    public String savePicture(Picture picture, byte[] raw) {

        String nameOfSavedPicture = PictureHandler.savePicture(raw);
        if (!GeneralErrors.isError(nameOfSavedPicture)) {
            picture.setPictureName(nameOfSavedPicture);
            pictureRepo.save(picture);
            return PICTURE_SAVED_SUCCESSFUL;
        }
        logger.info(COULD_NOT_SAVE_PICTURE);
        return COULD_NOT_SAVE_PICTURE;
    }

    public byte[] loadThumbnail(String uuid) {

        Picture p = pictureRepo.getByPictureNameEquals(uuid);
        if (p != null) {

            return PictureHandler.getThumbnailFromImage(uuid);
        }
        logger.info(COULD_NOT_LOAD_PICTURE);
        return null;
    }

    public String deletePicture(String uuid) {

         Picture p = pictureRepo.getByPictureNameEquals(uuid);
         if (p != null) {
             pictureRepo.delete(p);
             return DELETING_PICTURE_SUCCESSFUL;
         }
         logger.info(COULD_NOT_DELETE_PICTURE);
         return COULD_NOT_DELETE_PICTURE;
    }
}
