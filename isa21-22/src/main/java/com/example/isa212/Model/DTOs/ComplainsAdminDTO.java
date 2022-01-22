package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Enums.ReservationType;

public class ComplainsAdminDTO {

    private int id_complain;
    private String client_name;
    private String entityName;
    private ReservationType reservationType;
    private String textComplain;
    private String answer;
    private boolean isAnswered;

    public ComplainsAdminDTO(int id_complain, String client_name, String entityName, ReservationType reservationType, String textComplain, String answer, boolean isAnswered) {
        this.id_complain = id_complain;
        this.client_name = client_name;
        this.entityName = entityName;
        this.reservationType = reservationType;
        this.textComplain = textComplain;
        this.answer = answer;
        this.isAnswered = isAnswered;
    }

    public ComplainsAdminDTO() {
    }

    public int getId_complain() {
        return id_complain;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setId_complain(int id_complain) {
        this.id_complain = id_complain;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public String getTextComplain() {
        return textComplain;
    }

    public void setTextComplain(String textComplain) {
        this.textComplain = textComplain;
    }
}
