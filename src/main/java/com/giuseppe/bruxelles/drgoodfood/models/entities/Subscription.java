package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Long subscriptionId;

    @Column(nullable = false, name = "price")
    private int price;

    @Column(nullable = false, name = "num_of_meals_per_week")
    private int numOfMealsPerWeek;

    @Column(nullable = false, name = "start_date")
    private LocalDate startDate;

    @Column(nullable = false, name = "expiration_date")
    private LocalDate expirationDate;

    @Column(nullable = false, name = "is_active")
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
