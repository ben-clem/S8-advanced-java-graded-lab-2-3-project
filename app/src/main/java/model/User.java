package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    private String email;
    private String password;

    private Date dateSignUp;
    private Date dateLastSignIn;
    private Date dateLastAccess;

    public User(Date dateSignUp, Date dateLastSignIn, Date dateLastAccess, String email, String password) {
        this.dateSignUp = dateSignUp;
        this.dateLastSignIn = dateLastSignIn;
        this.dateLastAccess = dateLastAccess;
        this.email = email;
        this.password = password;
    }

    public User() {
    }


    public Date getDateSignUp() {
        return dateSignUp;
    }

    public void setDateSignUp(Date dateSignUp) {
        this.dateSignUp = dateSignUp;
    }

    public Date getDateLastSignIn() {
        return dateLastSignIn;
    }

    public void setDateLastSignIn(Date dateLastSignIn) {
        this.dateLastSignIn = dateLastSignIn;
    }

    public Date getDateLastAccess() {
        return dateLastAccess;
    }

    public void setDateLastAccess(Date dateLastAccess) {
        this.dateLastAccess = dateLastAccess;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email=" + email +
                ", dateSignUp=" + dateSignUp +
                ", dateLastSignIn=" + dateLastSignIn +
                ", dateLastAccess=" + dateLastAccess +
                '}';
    }
}
