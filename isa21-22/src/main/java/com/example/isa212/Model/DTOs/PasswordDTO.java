package com.example.isa212.Model.DTOs;

public class PasswordDTO {
    private String password;
    private String newPassword;
    private int idUser;

    public PasswordDTO() {
    }

    public PasswordDTO(String password, String newPassword, String newPasswordRepeat) {
        this.password = password;
        this.newPassword = newPassword;
    }

    public PasswordDTO(String password, String newPassword, int idUser) {
        this.password = password;
        this.newPassword = newPassword;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
