package com.fitness.service;

import com.fitness.table.Credential;
import com.fitness.table.User;

public interface CredentialService {
    Credential save(Credential credential, User user);
}
