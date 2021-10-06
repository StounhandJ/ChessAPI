package com.StounhandJ.ChessAPI.controller;

import com.StounhandJ.ChessAPI.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
