package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;
    private String avatar;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Date birthOfDate;
    private String phoneNumber;
    private int Point;
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;

}
