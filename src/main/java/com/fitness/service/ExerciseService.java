package com.fitness.service;

import com.fitness.dto.ExerciseDTO;
import com.fitness.exceptions.InvalidGoalException;
import com.fitness.table.Exercise;
import java.util.List;

public interface ExerciseService {

    List<Exercise> getAllExercise();

    Exercise getExerciseByActivityAndMinutes(String activityName, int minutes);

    Exercise save(ExerciseDTO exerciseDTO) throws InvalidGoalException;
}
