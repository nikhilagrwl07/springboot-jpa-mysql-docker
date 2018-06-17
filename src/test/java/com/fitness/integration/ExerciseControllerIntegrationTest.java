package com.fitness.integration;

import com.fitness.FitnessApplication;
import com.fitness.controller.ExerciseController;
import com.fitness.table.Exercise;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = FitnessApplication.class)
public class ExerciseControllerIntegrationTest {

    @Autowired
    ExerciseController exerciseController;

    @Test
    public void testfindAll(){
        List<Exercise> exercises = exerciseController.exercises();
        assertThat(exercises.size(), is(greaterThanOrEqualTo(0)));
    }

}
