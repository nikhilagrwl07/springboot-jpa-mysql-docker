package com.fitness.controller;

import com.fitness.dto.ExerciseDTO;
import com.fitness.exceptions.ErrorResponse;
import com.fitness.exceptions.InvalidGoalException;
import com.fitness.service.ExerciseService;
import com.fitness.table.Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.fitness.common.ResponseEnum.GOAL_NOT_FOUND;

@RestController
@RequestMapping(path = "/api/v1",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = {RequestMethod.GET, RequestMethod.POST})
public class ExerciseController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/exercises", method = RequestMethod.GET)
    public List<Exercise> exercises(){
        return exerciseService.getAllExercise();
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.GET)
    public ResponseEntity<?> getExerciseByActivityAndName(@RequestParam(value = "activity") String activity,
                                                       @RequestParam(value = "minutes") int minutes){
        Exercise exerciseByActivityAndMinutes = exerciseService.getExerciseByActivityAndMinutes(activity, minutes);
        if(exerciseByActivityAndMinutes!=null){
            return new ResponseEntity<>(exerciseByActivityAndMinutes,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/add/exercise", method = RequestMethod.POST)
    public ResponseEntity<?> addExercise(@Valid @RequestBody ExerciseDTO exerciseDTO, BindingResult bindingResult)  {
        if(bindingResult.hasErrors()){
            logger.error("Error Occurred");
            return getErrorResponse(bindingResult);
        }

        try {
            Exercise exercise = exerciseService.save(exerciseDTO);
            return new ResponseEntity<>(exercise, HttpStatus.OK);
        } catch (InvalidGoalException e) {
            return new ResponseEntity<>(new ErrorResponse(GOAL_NOT_FOUND, GOAL_NOT_FOUND.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
