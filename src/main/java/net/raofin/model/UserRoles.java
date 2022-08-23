package net.raofin.model;

import javax.persistence.*;

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

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "roleID=" + roleID +
                ", userID=" + userID +
                ", role='" + role + '\'' +
                '}';
    }
}
