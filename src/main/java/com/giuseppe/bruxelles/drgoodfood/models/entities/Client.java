package com.giuseppe.bruxelles.drgoodfood.models.entities;

import com.giuseppe.bruxelles.drgoodfood.enums.Status;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(nullable = false, name = "nickname")
    private String nickname;

    @Column(nullable = false, name = "mail_address")
    private String mailAddress;

    @Column(/*nullable = false, */name = "credit_card")
    private String creditCard;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private Status status = Status.BEGINNER;

    @OneToMany(mappedBy = "client") //done
    private List<Consultation> consultations;

    @OneToOne (mappedBy = "client") //done
    private  Subscription Subscription;

    @OneToMany(mappedBy = "client") //done
    private List<CustomerOrder> orders;

}
