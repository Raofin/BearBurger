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
public class Role
{
    @Id
    @Column(name = "Role_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "User_ID")
    private int userID;

    @Column(name = "Name")
    private String name;

    public Role() { }

    public Role(int userID) {
        this.userID = userID;
        this.name = "CUSTOMER";
    }

    public Role(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }
}