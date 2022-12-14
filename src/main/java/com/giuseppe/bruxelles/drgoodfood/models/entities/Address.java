package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(nullable = false, name = "num")
    private int num;

    @Column(nullable = false, name = "street")
    private String street;

    @Column(nullable = false, name = "zip_code")
    private int zipCode;

    @Column(nullable = false, name = "city")
    private String city;

    @OneToMany(mappedBy = "address")
    private List<Client> clients;

}
