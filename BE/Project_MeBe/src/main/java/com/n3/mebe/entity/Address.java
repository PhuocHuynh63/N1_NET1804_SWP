package com.n3.mebe.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @Column(name = "is_default")
    private boolean isDefault;

    private String title;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    private String country;

    private String city;

    @Column(name = "postal_code")
    private String postalCode;

}
