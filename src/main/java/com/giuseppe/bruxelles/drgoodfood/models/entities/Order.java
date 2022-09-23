package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private Address addressDelivery;

    @Column(nullable = false)
    private boolean isDelivered;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false) //done
    private Client client;

}
