package com.fitness.service.impl;

import com.fitness.exceptions.InvalidGoalException;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.repository.GoalRepository;
import com.fitness.repository.UserProfileRepository;
import com.fitness.repository.UserRepository;
import com.fitness.request.UserRequest;
import com.fitness.service.UserService;
import com.fitness.table.Goal;
import com.fitness.table.User;
import com.fitness.table.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.fitness.common.ResponseEnum.USER_NOT_FOUND;

@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    GoalRepository goalRepository;

    @Override
    @Transactional
    public User save(UserRequest userRequest) throws InvalidGoalException {

        Goal goal = goalRepository.findByGoalName(userRequest.getGoalName());

        if(goal==null){
            throw new InvalidGoalException("Goal does not exist");
        }

        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.addGoal(goal);

        UserProfile userProfile = new UserProfile();
        userProfile.setEmailAddress(userRequest.getEmailAddress());
        userProfile.setPhoneNumber(userRequest.getPhoneNumber());
//        userProfileRepository.save(userProfile);
        user.setUserProfile(userProfile);
        return userRepository.save(user);
    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) throws InvalidGoalException {
        Optional<UserProfile> userProfile = Optional.ofNullable(userProfileRepository.findByPhoneNumber(phoneNumber));
        log.info(userProfile.toString());
//        Optional<User> user = Optional.ofNullable(userRepository.findUserByPhoneNumber(phoneNumber));
        if(!userProfile.isPresent()){
          throw new InvalidGoalException(USER_NOT_FOUND.getMessage());
        }
        return userProfile.get().getUser();
    }

    @Override
    public User findUserByFirstName(String firstname) throws UserNotFoundException {
        Optional<User> userByFirstName = Optional.ofNullable(userRepository.findUserByFirstName(firstname));
        if(!userByFirstName.isPresent()){
            throw new UserNotFoundException(USER_NOT_FOUND.getMessage());
        }
        return userByFirstName.get();
    }
}
