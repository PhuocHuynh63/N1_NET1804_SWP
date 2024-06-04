package com.n3.mebe.dto.request.user;

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

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Date birthOfDate;
    private String phoneNumber;

}
