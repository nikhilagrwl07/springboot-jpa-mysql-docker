package com.fitness.controller;

import com.fitness.dto.CredentialDTO;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.CredentialRequest;
import com.fitness.service.CredentialService;
import com.fitness.table.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @RequestMapping(path = "/add/credentials", method = RequestMethod.POST)
    public User create(@Valid  @RequestBody CredentialRequest credentialRequest) throws UserNotFoundException {
        return credentialService.save(credentialRequest);
    }

    @RequestMapping(path = "/credential", method = RequestMethod.GET)
    public CredentialDTO getCreditnalsByUserFirstName(@RequestParam("userName") String userName) throws UserNotFoundException {
        log.info("test");
        return credentialService.getCreditnalsByFirstName(userName);
    }

}
