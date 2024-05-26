package com.n3.mebe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private int reviewId;
    private User user;
    private Product product;
    private String rating;
    private String comment;
    private Date createAt;

}
