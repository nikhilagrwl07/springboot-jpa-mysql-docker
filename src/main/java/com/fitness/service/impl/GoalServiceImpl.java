package com.fitness.service.impl;

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
        return goalRepository.save(goal);
    }
}
