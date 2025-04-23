package com.example.userbe.service.impl;

import com.example.userbe.dto.ResponseDTO;
import com.example.userbe.dto.UserDTO;
import com.example.userbe.entity.User;
import com.example.userbe.repo.UserRepo;
import com.example.userbe.service.UserService;
import com.example.userbe.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }
    }

    @Override
    public UserDTO searchUser(String username) {
        if (userRepository.existsByEmail(username)) {
            User user=userRepository.findByEmail(username);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public int updateUserRoleByEmail(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());

        if (user != null && userDTO.getRole() != null) {
            user.setRole(userDTO.getRole());
            userRepository.save(user);
            return VarList.Created;
        } else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int resetPass(UserDTO exuser) {
        if (!userRepository.existsByEmail(exuser.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            exuser.setPassword(passwordEncoder.encode(exuser.getPassword()));
            userRepository.updatepassword(exuser.getEmail(),exuser.getPassword());
            return VarList.Created;
        }
    }

    @Override
    public ResponseDTO existsByUsername(User user) {
        userRepository.save(user);
        return new ResponseDTO(VarList.Created, "User registered successfully", user);

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }
    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }
}
