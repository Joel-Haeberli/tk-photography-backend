package ch.joelhaeberli.tkpbackend.domain.picture;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepo extends PagingAndSortingRepository<Picture, Long> {

    public Picture getByPictureNameEquals(String uuid);
    public List<Picture> findAllByIdOrderByIdDesc(long id);
}
