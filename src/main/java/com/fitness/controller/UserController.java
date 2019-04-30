package com.fitness.controller;

import com.fitness.exceptions.InvalidGoalException;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.UserRequest;
import com.fitness.service.UserService;
import com.fitness.table.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/usersByFirstName")
    public ResponseEntity<User> getUserByFirstName(@RequestParam(value = "firstName") String firstName) throws UserNotFoundException
    {
        User user = userService.findUserByFirstName(firstName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(path = "/usersByPhoneNumber")
    public ResponseEntity<User> getUserByPhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber) throws InvalidGoalException {
        User userByPhoneNumber = userService.findUserByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(userByPhoneNumber, HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserRequest user) throws InvalidGoalException {
        User userSaved = userService.save(user);
        return new ResponseEntity<>(userSaved, HttpStatus.OK);
    }
}
