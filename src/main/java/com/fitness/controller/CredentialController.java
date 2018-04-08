package com.fitness.controller;

import com.fitness.dto.CredentialDTO;
import com.fitness.service.CredentialService;
import com.fitness.table.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = {RequestMethod.GET, RequestMethod.POST})

public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @RequestMapping(value = "credentials", method = RequestMethod.POST)
    public Credential create(@RequestBody CredentialDTO credentialDTO){
        return credentialService.save(credentialDTO.getCredential(), credentialDTO.getUser());
    }
}
