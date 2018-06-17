package com.fitness.service.impl;

import com.fitness.dto.CredentialDTO;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.repository.UserRepository;
import com.fitness.request.CredentialRequest;
import com.fitness.service.CredentialService;
import com.fitness.table.Credential;
import com.fitness.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.fitness.common.ResponseEnum.USER_NOT_FOUND;

@Service("credentialService")
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(CredentialRequest credentialRequest) throws UserNotFoundException {

        Optional<User> userByFirstName = Optional.ofNullable(userRepository.findUserByFirstName(credentialRequest.getFirstName()));

        if(!userByFirstName.isPresent())
        {
            throw new UserNotFoundException("User not found");
        }
        User u = userByFirstName.get();
        Credential credential = new Credential(u,credentialRequest.getUsername(), credentialRequest.getPassword());
        u.setCredential(credential);;

        return userRepository.save(u);
    }

    @Override
    public CredentialDTO getCreditnalsByFirstName(String userName) throws UserNotFoundException {
        Optional<User> userByFirstName = Optional.ofNullable(userRepository.findUserByFirstName(userName));

        if(!userByFirstName.isPresent())
        {
            throw new UserNotFoundException(USER_NOT_FOUND.getMessage());
        }
        User u = userByFirstName.get();
        return new CredentialDTO(u.getFirstName(),u.getLastName(),u.getCredential().getUsername(),u.getCredential().getPassword());

    }
}
