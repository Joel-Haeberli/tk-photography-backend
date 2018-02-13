package ch.joelhaeberli.tkpbackend.common.pictureutil;

import ch.joelhaeberli.tkpbackend.common.general.GeneralErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PictureHandler {

    private static final Logger logger = LoggerFactory.getLogger(PictureHandler.class);

    private static final String PICTURE_FORMAT = "png";

    private static final String DEFAULT_BASE_FOLDER = System.getProperty("user.home") + "/tkpBackend";
    private static final String PICTURE_PATH = DEFAULT_BASE_FOLDER + "/pictures/";

    private static final int THUMBNAIL_SCALE_FACTOR = 5;

    public static BufferedImage getBufferedImageFromByteArray(byte[] raw) {
        try {
            return ImageIO.read(new ByteArrayInputStream(raw));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public static BufferedImage getThumbnailFromImage(String pictureName) {

        BufferedImage bufferedImage = getBufferedImageFromDisk(pictureName);
        if (bufferedImage != null) {

            int newHeight = Math.round(bufferedImage.getHeight() / THUMBNAIL_SCALE_FACTOR);
            int newWidth = Math.round(bufferedImage.getWidth() / THUMBNAIL_SCALE_FACTOR);
            Image image = bufferedImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            Graphics graphics = bufferedImage.createGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();

            return bufferedImage;
        }
        logger.error(GeneralErrors.COULD_NOT_LOAD_PICTURE);
        return null;
    }

    public static BufferedImage getBufferedImageFromDisk(String pictureName) {

        logger.info("PATH : " + PICTURE_PATH + pictureName);
        File presentPicture = presentPicture(PICTURE_PATH + pictureName);
        if (presentPicture != null) {
            try {
                return ImageIO.read(presentPicture);
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
        return null;
    }

    private static File presentPicture(String picturePath) {

        File f = new File(picturePath);
        logger.info("FILE EXISTS : " + f.exists());
        return f;
    }

    //return picture path
    public static String savePicture(byte[] pictureData) {
        return savePicture(getBufferedImageFromByteArray(pictureData));
    }

    public static String savePicture(BufferedImage bufferedImage) {
        String pictureName = getUniquePictureName();
        File f = new File(PICTURE_PATH + pictureName);
        f.mkdirs();
        try {
            ImageIO.write(bufferedImage,PICTURE_FORMAT,f);
            return pictureName;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return GeneralErrors.COULD_NOT_SAVE_PICTURE;
    }

    private static String getUniquePictureName() {
        String uuid = UUID.randomUUID().toString() + "." + PICTURE_FORMAT;
        logger.info("generated name is " + uuid);
        return uuid;
    }
}
