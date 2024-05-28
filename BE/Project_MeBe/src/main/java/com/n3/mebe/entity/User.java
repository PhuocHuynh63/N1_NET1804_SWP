package com.n3.mebe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String password;
    private String role = "Member";

    @Column(name = "[birth_date]")
    private Date birthDate;

    @Column(name = "phone")
    private String phone;

    private int point;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updateAt;

    @Column(name = "deleted_at")
    private Date deleteAt;

    @OneToMany(mappedBy = "user")
    private Set<Address> listAddress;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviewsUser;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
}
