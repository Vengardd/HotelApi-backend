package com.spaghettiteam.hotelapi.model;

import javax.persistence.*;

@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;

    private String firstName;
    private String lastName;
    private String pesel;
    private String mobileNumber;
}
