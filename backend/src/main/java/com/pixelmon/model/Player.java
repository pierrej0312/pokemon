package com.pixelmon.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int posX;
    private int posY;
}