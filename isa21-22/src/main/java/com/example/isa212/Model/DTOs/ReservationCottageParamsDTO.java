package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Cottage;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class ReservationCottageParamsDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private LocalTime time;
    private int numDays;

    private String address;
    private double grade;

    public ReservationCottageParamsDTO() {
    }
    public ReservationCottageParamsDTO(int numDays) {
        this.numDays = numDays;
    }

    public ReservationCottageParamsDTO(Date date) {
        this.date = date;
    }
    public ReservationCottageParamsDTO(Date date, LocalTime time, int numDays) {

        this.date = date;
        this.time = time;
        this.numDays = numDays;
    }


    public ReservationCottageParamsDTO( Date date, LocalTime time, int numDays,  String address, double grade) {

        this.date = date;
        this.time = time;
        this.numDays = numDays;
        this.address = address;
        this.grade = grade;
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
}
