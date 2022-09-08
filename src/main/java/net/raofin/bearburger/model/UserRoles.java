package net.raofin.bearburger.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
public class UserRoles
{
    @Id
    @Column(name = "roleID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "userID")
    private int userID;

    @Column(name = "role")
    private String role;

    public UserRoles() { }

    public UserRoles(int userID) {
        this.userID = userID;
        this.role = "CUSTOMER";
    }

    public UserRoles(int userID, String role) {
        this.userID = userID;
        this.role = role;
    }
}