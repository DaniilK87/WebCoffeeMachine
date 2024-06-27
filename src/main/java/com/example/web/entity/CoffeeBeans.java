package com.example.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "coffee_beans")
@NoArgsConstructor
public class CoffeeBeans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "portion")
    private int portion;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Coffee coffee;
}
