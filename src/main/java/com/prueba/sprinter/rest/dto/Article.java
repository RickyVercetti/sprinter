package com.prueba.sprinter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int code;
    @Column(nullable = false)
    private String name;
    private String color;
    private String size;
    private Double price;
}
