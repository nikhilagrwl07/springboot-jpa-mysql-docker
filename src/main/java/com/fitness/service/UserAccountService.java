package com.fitness.service;

import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.UserWithAccountRequest;

public interface UserAccountService {
    void save(UserWithAccountRequest UserWithAccountRequest) throws UserNotFoundException;
}
