package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Cottage;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class ReservationParamsDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private LocalTime time;
    private int numDays;
    private int numPersons;

    private String address;
    private double grade;
    private int id_client;

    public ReservationParamsDTO() {
    }



    public ReservationParamsDTO(Date date, LocalTime time, int numDays) {

        this.date = date;
        this.time = time;
        this.numDays = numDays;
    }


    public ReservationParamsDTO(Date date, LocalTime time, int numDays, int numPersons, String address, double grade, int id_client) {
        this.date = date;
        this.time = time;
        this.numDays = numDays;
        this.numPersons = numPersons;
        this.address = address;
        this.grade = grade;
        this.id_client = id_client;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getNumPersons() {
        return numPersons;
    }

    public void setNumPersons(int numPersons) {
        this.numPersons = numPersons;
    }
}
