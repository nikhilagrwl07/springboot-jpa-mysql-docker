package com.fitness.service;

import com.fitness.exceptions.InvalidGoalException;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.UserRequest;
import com.fitness.table.User;

public interface UserService {

    User save(UserRequest user ) throws InvalidGoalException;

    User  findUserByPhoneNumber(String phoneNumber) throws InvalidGoalException;

    User  findUserByFirstName(String firstname) throws UserNotFoundException;
}
