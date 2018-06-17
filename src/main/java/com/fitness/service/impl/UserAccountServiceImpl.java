package com.fitness.service.impl;

import com.fitness.exceptions.UserNotFoundException;
import com.fitness.request.UserWithAccountRequest;
import com.fitness.repository.UserRepository;
import com.fitness.service.UserAccountService;
import com.fitness.table.User;
import com.fitness.table.UserAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(UserWithAccountRequest userDTOWithAccount) throws UserNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByFirstName(userDTOWithAccount.getUserName()));

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        User u= user.get();

        UserAccountDetails userAccountDetails = new UserAccountDetails();
        userAccountDetails.setDepositedGymBalance(userDTOWithAccount.getInitialBalance());
        userAccountDetails.setName(userDTOWithAccount.getAccountName());
        userAccountDetails.setUser(u);
        u.setUserAccountDetails(userAccountDetails);
        userRepository.save(u);
    }
}
