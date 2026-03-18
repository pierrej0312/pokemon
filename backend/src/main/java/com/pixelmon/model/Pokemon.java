package com.pixelmon.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pokemon {
    @Id @GeneratedValue
    private Long id;
    private int apiId;
    private String name;
    private int level;
}