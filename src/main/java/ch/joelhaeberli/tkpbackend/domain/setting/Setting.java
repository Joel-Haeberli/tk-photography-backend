package ch.joelhaeberli.tkpbackend.domain.setting;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Setting {

    @Id
    public String id;
    public String value;

    public Setting() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
