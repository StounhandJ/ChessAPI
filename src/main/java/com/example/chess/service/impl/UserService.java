package com.example.chess.service.impl;
import com.example.chess.model.User;
import com.example.chess.repository.IUserRepository;
import java.util.List;

import com.example.chess.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
