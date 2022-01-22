package com.example.isa212.Model.DTOs;

public class DeleteReqDTO {

    private int id_req;
    private String email;
    private String text;
    private boolean isApproved;

    public DeleteReqDTO() {
    }

    public DeleteReqDTO(int id_req, String email, String text, boolean isApproved) {
        this.id_req = id_req;
        this.email = email;
        this.text = text;
        this.isApproved = isApproved;
    }

    public int getId_req() {
        return id_req;
    }

    public void setId_req(int id_req) {
        this.id_req = id_req;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
