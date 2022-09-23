package com.giuseppe.bruxelles.drgoodfood.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeekDeliverySubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int mealsPerWeek;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private boolean isActive;

    @OneToOne
    private Client client;


}
