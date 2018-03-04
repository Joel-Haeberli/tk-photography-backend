package ch.joelhaeberli.tkpbackend.service;

import ch.joelhaeberli.tkpbackend.domain.setting.Setting;
import ch.joelhaeberli.tkpbackend.domain.setting.SettingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService {

    Logger logger = LoggerFactory.getLogger(SettingService.class);

    @Autowired
    SettingRepo settingRepo;

    public Setting getSetting(String id) {

         return settingRepo.findOne(id);
    }

    public Setting addSetting(Setting s) {

        return settingRepo.saveAndFlush(s);
    }

    public Setting updateSetting(Setting s) {

        return settingRepo.saveAndFlush(s);
    }

    public void deleteSetting(String id) {

        settingRepo.delete(id);
    }
}
