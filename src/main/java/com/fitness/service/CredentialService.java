package com.fitness.service;

import com.fitness.dto.CredentialDTO;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.CredentialRequest;
import com.fitness.table.User;

public interface CredentialService {
    User save(CredentialRequest credentialRequest) throws UserNotFoundException;

    CredentialDTO getCreditnalsByFirstName(String userName) throws UserNotFoundException;
}
