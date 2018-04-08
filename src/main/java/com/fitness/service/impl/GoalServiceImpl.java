package com.fitness.service.impl;

import com.fitness.repository.GoalRepository;
import com.fitness.repository.GoalRepository;
import com.fitness.service.GoalService;
import com.fitness.table.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

    @Autowired
    GoalRepository goalRepository;

    @Override
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @Override
    public Goal save(Goal goal) {

//         user.setGoal(goal);
//         goal.setUser(user);

//        User user = goal.getUser();
//        UserProfile userProfile = goal.getUser().getUserProfile();

//        userProfile.setUser(user);
//        user.setUserProfile(userProfile);

//        goal.setUser(user);


//        for(int i=0;goal.getExercises()!=null && i<goal.getExercises().size();i++)
//        {
//            goal.getExercises().get(i).setGoal(goal);
//        }
//        goal.getUser().setGoal(goal);

        return goalRepository.saveAndFlush(goal);
    }
}
