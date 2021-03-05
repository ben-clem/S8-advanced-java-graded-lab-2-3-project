package model.entitity;

import java.io.Serializable;

public class PropertyId implements Serializable {
    private String key;
    private String value;

    // default constructor
    public PropertyId() {
    }

    public PropertyId(String key, String value) {
        this.key = key;
        this.value = value;
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
// equals() and hashCode()
}


