package com.example.isa212.Model.DTOs;

public class RegistrationApprovalDTO {

    private int id;
    private String user_name;
    private String email;
    private String type;
    private boolean isAprove;

    public RegistrationApprovalDTO(int id, String user_name, String email, String type, boolean isAprove) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.type = type;
        this.isAprove = isAprove;
    }

    public boolean isAprove() {
        return isAprove;
    }

    public void setAprove(boolean aprove) {
        isAprove = aprove;
    }

    public RegistrationApprovalDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
