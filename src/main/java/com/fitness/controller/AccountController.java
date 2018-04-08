package com.fitness.controller;

import com.fitness.dto.UserDTOWithAccount;
import com.fitness.service.AccountService;
import com.fitness.table.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = {RequestMethod.GET, RequestMethod.POST})

public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "addAccount", method = RequestMethod.POST)
    public void create(@RequestBody UserDTOWithAccount userDTOWithAccount){
        accountService.save(userDTOWithAccount);
    }

    @RequestMapping(value = "allAccount", method = RequestMethod.GET)
    public List<Account> list(){
        return accountService.getAllAccount();
    }
}
