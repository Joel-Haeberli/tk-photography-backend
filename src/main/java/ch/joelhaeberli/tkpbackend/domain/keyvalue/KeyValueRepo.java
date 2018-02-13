package ch.joelhaeberli.tkpbackend.domain.keyvalue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyValueRepo extends JpaRepository<KeyValue, Long> {
}
