package com.example.userbe.repo;

import com.example.userbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String userName);

    boolean existsByEmail(String userName);


    User findByUsername(String username);
    @Modifying
    @Query(value = "UPDATE systemuser u SET u.email = ?2 WHERE u.first_name = ?1", nativeQuery = true)
    void updatepassword(String email, String password);

}
