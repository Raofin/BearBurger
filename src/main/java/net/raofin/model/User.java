package net.raofin.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @NotNull
    @Size(min = 4, max = 15)
    @Column(name = "username")
    private String username;

    @Email
    @NotNull
    @Size(min = 6, max = 30)
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 6, max = 30)
    @Column(name = "password")
    private String password;

    @Size(min = 6, max = 30)
    @Transient
    private String cPassword;

    @NotNull
    @Size(min = 11, max = 20)
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @Column(name = "spent")
    private String spent = "0";

    @Column(name = "enabled")
    private boolean isEnabled = true;

    @Column(name = "regDate")
    private Date regDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID")
    private List<UserRoles> userRoles;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpent() {
        return spent;
    }

    public void setSpent(String spent) {
        this.spent = spent;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Date getRegDate() {
        return regDate;
    }

    public String getRegDateFormatted() {
        String pattern = "E, dd MMM yyyy"; // Sun, 21 Aug 2022 11:34 PM
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern/*, new Locale("Asia/Dhaka")*/);
        return simpleDateFormat.format(regDate);
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", spent='" + spent + '\'' +
                ", isEnabled=" + isEnabled +
                ", regDate=" + regDate +
                ", userRole=" + userRoles +
                '}';
    }
}
