package com.example.isa212.Model;

import com.example.isa212.Model.Users.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Table
@Entity
public class DeleteAccountRequest {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_accRequest;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private  Client client;

    @Column
    private String text;

    @Column
    private boolean isApproved;

    public DeleteAccountRequest() {
    }

    public DeleteAccountRequest(int id_accRequest, Client client, String text, boolean isApproved) {
        this.id_accRequest = id_accRequest;
        this.client = client;
        this.text = text;
        this.isApproved = isApproved;
    }




    public DeleteAccountRequest(Client client, String text, boolean isApproved) {
        this.client = client;
        this.text = text;
        this.isApproved = isApproved;
    }

    public int getId_accRequest() {
        return id_accRequest;
    }

    public void setId_accRequest(int id_accRequest) {
        this.id_accRequest = id_accRequest;
    }

    public Client getClient() {
        return client;
    }

    public String getEmail()
    {
        return getClient().getEmail();
    }

    public void setClient(Client client) {
        this.client = client;
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
