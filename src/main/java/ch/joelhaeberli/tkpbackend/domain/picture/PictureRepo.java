package ch.joelhaeberli.tkpbackend.domain.picture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepo extends JpaRepository<Picture, Long> {
}
