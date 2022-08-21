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

    @Column(name = "role")
    private String role = "CUSTOMER";

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleID=" + roleID +
                ", role='" + role + '\'' +
                '}';
    }
}
