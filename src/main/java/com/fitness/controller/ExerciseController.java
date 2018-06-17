package com.fitness.controller;

import com.fitness.request.ExerciseRequest;
import com.fitness.exceptions.InvalidGoalException;
import com.fitness.service.ExerciseService;
import com.fitness.table.Exercise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.fitness.common.ResponseEnum.GOAL_NOT_FOUND;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class ExerciseController{

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @RequestMapping(path = "/exercises", method = RequestMethod.GET)
    public List<Exercise> exercises(){
        long l = System.currentTimeMillis();
        List<Exercise> allExercise = exerciseService.getAllExercise();
        long timetaken = System.currentTimeMillis()-l;
        this.gaugeService.submit("ExerciseController-timetaken", timetaken);
        this.counterService.increment("ExerciseController-count");
        return allExercise;
    }

    @RequestMapping(path = "/exercise", method = RequestMethod.GET)
    public ResponseEntity<Exercise> getExerciseByActivityAndName(@RequestParam(value = "activity") String activity,
                                                       @RequestParam(value = "minutes") int minutes){
        Exercise exerciseByActivityAndMinutes = exerciseService.getExerciseByActivityAndMinutes(activity, minutes);
        if(exerciseByActivityAndMinutes!=null){
            return new ResponseEntity<>(exerciseByActivityAndMinutes,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/add/exercise", method = RequestMethod.POST)
    public ResponseEntity<Exercise> addExercise(@Valid @RequestBody ExerciseRequest exerciseRequest) throws InvalidGoalException {
        try {
            Exercise exercise = exerciseService.save(exerciseRequest);
            return new ResponseEntity<>(exercise, HttpStatus.OK);
        } catch (InvalidGoalException e) {
            throw new InvalidGoalException(GOAL_NOT_FOUND.getMessage());
        }
    }
}
