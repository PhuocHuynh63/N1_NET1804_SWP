package com.n3.mebe.service;


import com.n3.mebe.dto.request.UserCreateRequest;
import com.n3.mebe.dto.request.UserUpdateRequest;
import com.n3.mebe.entity.User;
import com.n3.mebe.exception.AppException;
import com.n3.mebe.exception.ErrorCode;
import com.n3.mebe.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;


    public User getCreateUser(UserCreateRequest request){
        User user = new User();

        if (iUserRepository.existsByEmail(request.getEmail())){
            throw new AppException(ErrorCode.USER_EXIST);
        }

        user.setAvatar(request.getAvatar());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setBirthDate(request.getBirthOfDate());
        user.setPhone(request.getPhoneNumber());
        user.setPoint(request.getPoint());
        user.setCreateAt(request.getCreateAt());
        user.setUpdateAt(request.getUpdateAt());
        user.setDeleteAt(request.getDeleteAt());

        return iUserRepository.save(user);
    }

    public List<User> getAllUser(){
        return iUserRepository.findAll();
    }

    public User getUserById(int id){
        return  iUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUserById(int id, UserUpdateRequest request){

        User user = getUserById(id);

        user.setAvatar(request.getAvatar());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setBirthDate(request.getBirthOfDate());
        user.setPhone(request.getPhoneNumber());
        user.setPoint(request.getPoint());
        user.setCreateAt(request.getCreateAt());
        user.setUpdateAt(request.getUpdateAt());
        user.setDeleteAt(request.getDeleteAt());

        return  iUserRepository.save(user);
    }

    public void deleteUserById(int id){
        iUserRepository.deleteById(id);
    }

}
