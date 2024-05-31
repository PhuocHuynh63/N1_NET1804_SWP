package com.n3.mebe.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String avatar;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Date birthOfDate;
    private String phoneNumber;
    private int point;
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;

}
