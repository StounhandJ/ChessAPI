package com.StounhandJ.ChessAPI.service.impl;
import com.StounhandJ.ChessAPI.model.User;
import com.StounhandJ.ChessAPI.repository.IUserRepository;
import java.util.List;

import com.StounhandJ.ChessAPI.service.IUserService;
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
