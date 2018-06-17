package com.fitness.controller;

import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.UserWithAccountRequest;
import com.fitness.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class UserAccountController {

    @Autowired
    private UserAccountService accountService;

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public void create(@RequestBody UserWithAccountRequest userDTOWithAccount) throws UserNotFoundException {
        accountService.save(userDTOWithAccount);
    }

//    @RequestMapping(value = "allAccount", method = RequestMethod.GET)
//    public List<UserGymAccount> list(){
//        return accountService.getAllAccount();
//    }
}
