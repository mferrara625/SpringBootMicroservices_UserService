package com.SpringBootMicroservices.user.controller;

import com.SpringBootMicroservices.user.VO.ResponseTemplateVO;
import com.SpringBootMicroservices.user.entity.User1;
import com.SpringBootMicroservices.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User1 saveUser(@RequestBody User1 user1){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user1);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
