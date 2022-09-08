package net.raofin.bearburger.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
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
    @Size(min = 4, max = 62)
    @Column(name = "password")
    private String password;

    @Transient
    @Size(min = 6, max = 30)
    private String cPassword;

    @NotNull
    @Size(min = 6, max = 14)
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @Column(name = "spent")
    private int spent = 0;

    @Column(name = "enabled")
    private boolean isEnabled = true;

    @CreationTimestamp
    @Column(name = "regDate")
    private Date regDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID")
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
