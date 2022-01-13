package com.example.isa212.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class ProjImage {
    @Id
    @Column
    private int id;

    @Column
    private String imageHash;
}
