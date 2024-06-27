package com.example.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "coffee")
@NoArgsConstructor
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "coffee_type")
    private String coffeeType;

    @OneToOne(mappedBy = "coffee", fetch = FetchType.LAZY)
    private CoffeeBeans coffeeBeans;

    @OneToOne(mappedBy = "coffee", fetch = FetchType.LAZY)
    private Milk milk;

    @OneToOne(mappedBy = "coffee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Water water;
}
