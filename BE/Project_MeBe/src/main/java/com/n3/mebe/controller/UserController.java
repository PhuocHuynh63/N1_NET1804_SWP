package com.n3.mebe.controller;


import com.n3.mebe.dto.request.UserCreateRequest;
import com.n3.mebe.dto.request.UserUpdateRequest;
import com.n3.mebe.entity.User;
import com.n3.mebe.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create_user")
    public User createUser(@RequestBody @Valid UserCreateRequest request) {
        return userService.getCreateUser(request);
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.getAllUser();
    }

    @GetMapping("/{user_id}")
    public User getUser(@PathVariable("user_id") int user_id) {
        return userService.getUserById(user_id);
    }

    @PutMapping("/{user_id}")
    public User updatetUser(@PathVariable("user_id") int user_id, @RequestBody UserUpdateRequest request) {
        return userService.updateUserById(user_id , request);
    }

    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable("user_id") int user_id) {
        userService.deleteUserById(user_id);
        return "User have been deleted";
    }


}
