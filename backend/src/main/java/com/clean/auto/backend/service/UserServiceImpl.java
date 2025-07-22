package com.clean.auto.backend.service;

import org.springframework.stereotype.Service;
import com.clean.auto.backend.repository.UsersRepository;
import com.clean.auto.backend.entity.Users;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    

    private final UsersRepository usersRepository;


    public UserServiceImpl(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }


    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }


    @Override
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Long id)
    {
        return usersRepository.findById(id).orElse(null);
    }




   




}