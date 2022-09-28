package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customerorder")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(nullable = false, name = "is_delivered")
    private boolean isDelivered;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}
