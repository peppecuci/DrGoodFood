package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(nullable = false)
    private int num;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private int zipCode;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

}
