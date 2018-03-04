package ch.joelhaeberli.tkpbackend.domain.setting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepo extends JpaRepository<Setting, String> {
}
