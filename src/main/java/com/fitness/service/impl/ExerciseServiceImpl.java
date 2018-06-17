package com.fitness.service.impl;

import com.fitness.exceptions.InvalidGoalException;
import com.fitness.repository.ExerciseRepository;
import com.fitness.repository.GoalRepository;
import com.fitness.request.ExerciseRequest;
import com.fitness.service.ExerciseService;
import com.fitness.table.Exercise;
import com.fitness.table.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public List<Exercise> getAllExercise() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise getExerciseByActivityAndMinutes(String activityName, int minutes) {
        return exerciseRepository.findByActivityAndMinutes(activityName,minutes);
    }

    @Override
    public Exercise save(ExerciseRequest exerciseRequest) throws InvalidGoalException {
        Goal goal = goalRepository.findByGoalName(exerciseRequest.getGoalName());
        if(goal==null)
        {
            throw new InvalidGoalException("Goal does not exist");
        }

        // If some exercise is existing then add new exercise or else add first time
        List<Exercise> exerciseList = goal.getExercises();

        Exercise exercise = new Exercise();
        exercise.setActivity(exerciseRequest.getActivity());
        exercise.setGoal(goal);
        exercise.setMinutes(exerciseRequest.getMinutes());
        exerciseList.add(exercise);

//        goal.getExercises().add(exercise);

        exerciseList.forEach(e -> exerciseRepository.save(e));
        return exercise;

    }
}
