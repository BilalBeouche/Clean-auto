package com.clean.auto.backend.service;

import java.util.List;

import com.clean.auto.backend.entity.Users;

public interface UserService {

    Users saveUser(Users user);

    List<Users> getAllUsers();

    Users getUserById(Long id);

    Users updateUser(Long id, Users user);

    void deleteUser(Long id);

    Users getCurrentUsers();

}
