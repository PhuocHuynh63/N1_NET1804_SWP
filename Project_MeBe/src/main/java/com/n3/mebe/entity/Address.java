package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int addressId;
    private User user;
    private boolean isDefault;
    private String title;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
    private String postalCode;

}
