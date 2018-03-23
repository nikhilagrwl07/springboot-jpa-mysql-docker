package com.fitness.service;

import com.fitness.table.Goal;

import java.util.List;

public interface GoalService {

    List<Goal> getAllGoals();

    Goal save(Goal goal);
}
