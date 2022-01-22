package com.example.isa212.Model;

import javax.persistence.*;

@Table
@Entity
public class RegistrationApproval {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_registrationApproval;
    @Column
    private int id_user;
    @Column
    private Boolean isApproved;
    @Column
    private String autority;

    public RegistrationApproval() {
    }

    public RegistrationApproval(int id_registrationApproval, int id_user, Boolean isApproved, String autority) {
        this.id_registrationApproval = id_registrationApproval;
        this.id_user = id_user;
        this.isApproved = isApproved;
        this.autority = autority;
    }

    public int getId_registrationApproval() {
        return id_registrationApproval;
    }

    public void setId_registrationApproval(int id_registrationApproval) {
        this.id_registrationApproval = id_registrationApproval;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public String getAutority() {
        return autority;
    }

    public void setAutority(String autority) {
        this.autority = autority;
    }
}
