package com.example.userbe.service;

import com.example.userbe.dto.ResponseDTO;
import com.example.userbe.dto.UserDTO;
import com.example.userbe.entity.User;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String userName);

    public int updateUserRoleByEmail(UserDTO userDTO) ;

    int resetPass(UserDTO exuser);

    ResponseDTO existsByUsername(User user);



    List<UserDTO> getAllUsers();
//    int deleteUser(String email);

}

