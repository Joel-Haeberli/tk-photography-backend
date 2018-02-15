package ch.joelhaeberli.tkpbackend.domain.picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepo extends JpaRepository<Picture, Long> {

    public Picture getByPictureNameEquals(String uuid);
    public List<Picture> getAllByIdOrderByIdDesc();
}
