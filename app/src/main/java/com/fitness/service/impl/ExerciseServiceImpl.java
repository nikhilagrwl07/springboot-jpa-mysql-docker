package com.fitness.service.impl;

import com.fitness.exceptions.InvalidGoalException;
import com.fitness.repository.ExerciseRepository;
import com.fitness.repository.GoalRepository;
import com.fitness.exceptions.InvalidGoalException;
import com.fitness.dto.ExerciseDTO;
import com.fitness.repository.GoalRepository;
import com.fitness.repository.ExerciseRepository;
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
    public Exercise save(ExerciseDTO exerciseDTO) throws InvalidGoalException {
        Goal goal = goalRepository.findByGoalname(exerciseDTO.getGoalName());
        if(goal==null)
        {
            throw new InvalidGoalException("Goal does not exist");
        }

        List<Exercise> exerciseList = exerciseRepository.findByGoalAndActivity(goal,exerciseDTO.getActivity());

        if(exerciseList!=null && !exerciseList.isEmpty())
        {
            throw new InvalidGoalException("Activity already existing with goal.");
        }
        Exercise exercise = new Exercise();
        exercise.setActivity(exerciseDTO.getActivity());
        exercise.setGoal(goal);
        exercise.setMinutes(exerciseDTO.getMinutes());
        return exerciseRepository.saveAndFlush(exercise);
    }
}
