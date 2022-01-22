package com.example.isa212.Model.DTOs;

import com.example.isa212.Model.Enums.RoyalType;

public class ClientDTO {

    private int penality;
    private RoyalType royalType;

    public ClientDTO() {
    }

    public ClientDTO(int penalityl, RoyalType royalType) {
        this.penality = penalityl;
        this.royalType = royalType;

    }

    public int getPenality() {
        return penality;
    }

    public void setPenality(int penality) {
        this.penality = penality;
    }

    public RoyalType getRoyalType() {
        return royalType;
    }

    public void setRoyalType(RoyalType royalType) {
        this.royalType = royalType;
    }
}
