package com.example.isa212.Model;

import com.example.isa212.Model.Enums.ReservationType;
import com.example.isa212.Model.Users.Client;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "Complains")
@Inheritance(strategy = InheritanceType.JOINED)
public class Complains {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_complain;
    @Column
    private String textComplain;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Column
    private String name;

    @Column(nullable = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String answer;

    @Column
    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;

    @Column
    private boolean isAnswered;

    public Complains() {
    }

    public Complains(int id_complain, String textComplain, Client client, String name, String answer, ReservationType reservationType, boolean isAnswered) {
        this.id_complain = id_complain;
        this.textComplain = textComplain;
        this.client = client;
        this.name = name;
        this.answer = answer;
        this.reservationType = reservationType;
        this.isAnswered = isAnswered;
    }

    public int getId_complain() {
        return id_complain;
    }

    public void setId_complain(int id_complain) {
        this.id_complain = id_complain;
    }

    public String getTextComplain() {
        return textComplain;
    }

    public void setTextComplain(String textComplain) {
        this.textComplain = textComplain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
