package com.fitness.service.impl;

import com.fitness.repository.CredentialRepository;
import com.fitness.service.CredentialService;
import com.fitness.table.Credential;
import com.fitness.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("credentialService")
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    CredentialRepository credentialRepository;

    @Override
    public Credential save(Credential credential, User user) {
        credential.setUser(user);

        user.setCredential(credential); // for bidirectional

        return credentialRepository.save(credential);
    }
}
