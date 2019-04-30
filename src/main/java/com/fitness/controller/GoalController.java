package com.fitness.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.service.GoalService;
import com.fitness.table.Goal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class GoalController {

    @Autowired
    private GoalService goalService;

    //    @TrackTime
    @GetMapping(path = "/goals")
    public List<Goal> list(){
        return goalService.getAllGoals();
    }


//    @TrackTime
    @PostMapping(path = "/goals")
    public Goal create(@RequestBody Goal goal) throws JsonProcessingException {
        Goal goalSaved = goalService.save(goal);
        log.info(" Saved - {} ",new ObjectMapper().writeValueAsString(goalSaved));
        return goalSaved;
    }
}
