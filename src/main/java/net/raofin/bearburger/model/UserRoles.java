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
@Table(name = "Roles")
public class UserRoles
{
    @Id
    @Column(name = "Role_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "User_ID")
    private int userID;

    @Column(name = "Role")
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