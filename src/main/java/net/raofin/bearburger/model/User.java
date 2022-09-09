package net.raofin.bearburger.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User
{
    @Id
    @Column(name = "User_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @NotNull
    @Size(min = 4, max = 15)
    @Column(name = "Username")
    private String username;

    @Email
    @NotNull
    @Size(min = 6, max = 30)
    @Column(name = "Email")
    private String email;

    @NotNull
    @Size(min = 4, max = 62)
    @Column(name = "Password")
    private String password;

    @Transient
    @Size(min = 6, max = 30)
    private String cPassword;

    @NotNull
    @Size(min = 6, max = 14)
    @Column(name = "Phone_Number")
    private String phoneNumber;

    @NotNull
    @Column(name = "Gender")
    private String gender;

    @Column(name = "Spent")
    private int spent = 0;

    @Column(name = "Enabled")
    private boolean isEnabled = true;

    @Column(name = "Reg_Date")
    @CreationTimestamp
    private Date regDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "User_ID")
    private List<UserRoles> userRoles;

    public String getRegDateFormatted() {
        String pattern = "E, dd MMM yyyy"; // Sun, 21 Aug 2022 11:34 PM
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern/*, new Locale("Asia/Dhaka")*/);
        return simpleDateFormat.format(regDate);
    }

    public String getcPassword() {
        return cPassword;
    }
}
