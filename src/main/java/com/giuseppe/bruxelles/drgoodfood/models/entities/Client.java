package com.giuseppe.bruxelles.drgoodfood.models.entities;

import com.giuseppe.bruxelles.drgoodfood.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String mailAddress;

    @Column(nullable = false)
    private String creditCard;

    @Column(nullable = false)
    @OneToMany(mappedBy = "client") //done
    private List<Address> address;

    @Column(nullable = false)
    private Status status = Status.BEGINNER;

    @OneToMany(mappedBy = "client") //done
    private List<Consultation> consultations;

    @OneToOne (mappedBy = "client") //done
    private  WeekDeliverySubscription weekDeliverySubscription;

    @OneToMany(mappedBy = "client") //done
    private List<Order> orders;

}
