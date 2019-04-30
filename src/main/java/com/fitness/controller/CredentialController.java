package com.fitness.controller;

import com.fitness.dto.CredentialDTO;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.CredentialRequest;
import com.fitness.service.CredentialService;
import com.fitness.table.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class CredentialController {

    private final CredentialService credentialService;

    @Autowired
    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping(path = "/credentials")
    public ResponseEntity<Object> create(@Valid  @RequestBody CredentialRequest credentialRequest) throws UserNotFoundException {
        User savedUser = credentialService.save(credentialRequest);

        URI savedUserUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(savedUserUri).build(); // response header will have something like /credentials/1 to access value
    }

    @GetMapping(path = "/credentials")
    public ResponseEntity<CredentialDTO> getCreditnalsByUserFirstName(@RequestParam("userName") String userName) throws UserNotFoundException {
        CredentialDTO credentialsByFirstName = credentialService.getCreditnalsByFirstName(userName);

        return ResponseEntity.ok(credentialsByFirstName);
    }

}
