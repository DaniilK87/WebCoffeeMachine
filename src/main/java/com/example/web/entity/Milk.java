package com.example.web.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "milk")
public class Milk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "portion")
    private int portion;

    @OneToOne(fetch = FetchType.LAZY)
    private Coffee coffee;
}
