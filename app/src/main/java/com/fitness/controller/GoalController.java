package com.fitness.controller;

import com.fitness.service.GoalService;
import com.fitness.table.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = {RequestMethod.GET, RequestMethod.POST})

public class GoalController {

    @Autowired
    private GoalService goalService;

    @RequestMapping(value = "goals", method = RequestMethod.GET)
    public List<Goal> list(){
        return goalService.getAllGoals();
    }

    @RequestMapping(value = "goal", method = RequestMethod.POST)
    public Goal create(@RequestBody Goal goal){
       return goalService.save(goal);
    }
}
