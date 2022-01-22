package com.example.isa212.Model.DTOs;

public class ComplainsDTO
{
    private int id_client;
    private String entityName;
    private String text;
    private String name;

    public ComplainsDTO() {
    }

    public ComplainsDTO(int id_client, String entityName, String text, String name) {
        this.id_client = id_client;
        this.entityName = entityName;
        this.text = text;
        this.name = name;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
