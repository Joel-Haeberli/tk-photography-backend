package ch.joelhaeberli.tkpbackend.domain.keyvalue;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KeyValue {

    @Id
    public String key;
    public String value;

    public KeyValue() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
