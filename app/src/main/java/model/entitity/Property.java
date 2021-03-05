package model.entitity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Properties")
@IdClass(PropertyId.class)
public class Property {

    private String userEmail;

    @Id
    private String key;
    @Id
    private String value;


    public Property() {
    }

    public Property(String userEmail, String key, String value) {
        this.userEmail = userEmail;
        this.key = key;
        this.value = value;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    @Override
    public String toString() {
        return "Property{" +
                "userEmail=" + userEmail +
                ", key=" + key +
                ", value=" + value +
                '}';
    }
}
