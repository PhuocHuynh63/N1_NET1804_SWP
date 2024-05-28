package com.n3.mebe.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    private String avatar;
    private String firstName;
    private String lastName;

    @Email(message = "Email must be .....@gmail.com")
    private String email;

    @Size(min = 8, message = "Password must be at least 8 character")
    private String password;

    @NotEmpty( message = "Must be have")
    private String role;
    private Date birthOfDate;
    private String phoneNumber;
    private int point;
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;
}
