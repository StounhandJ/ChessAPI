package com.example.chess.controller;

import com.example.chess.model.User;
import com.example.chess.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public Object test(
            HttpSession httpSession
    ) {
        return userService.findAll();
    }


}
