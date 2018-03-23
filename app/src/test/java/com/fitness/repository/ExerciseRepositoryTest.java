package com.fitness.repository;

import com.fitness.interceptors.RequestInterceptor;
import com.fitness.table.Exercise;
import com.fitness.table.Goal;
import com.fitness.beans.DocketBean;
import com.fitness.interceptors.RequestInterceptor;
import com.fitness.table.Exercise;
import com.fitness.table.Goal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
public class ExerciseRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ExerciseRepository exerciseRepository;

    @MockBean
    RequestInterceptor requestInterceptor;

    @MockBean
    DocketBean docketBean;

    private Exercise exercise;
    private Exercise secondExercise;
    private Goal goal;

    @Before
    public void setUp() {
        goal = new Goal();
        goal.setGoalname("goalname 1");
        goal.setMinutes(60);
        goal.setCreatedBy("USER");
        goal.setLastModifiedBy("USER");

        exercise = new Exercise();
        exercise.setActivity("activity1");
        exercise.setMinutes(20);
        exercise.setCreatedBy("USER");
        exercise.setLastModifiedBy("USER");

        exercise.setGoal(goal);

        secondExercise = new Exercise();
        secondExercise.setActivity("activity1");
        secondExercise.setMinutes(25);
        secondExercise.setCreatedBy("USER");
        secondExercise.setLastModifiedBy("USER");

        secondExercise.setGoal(goal);
    }

    @After
    public void tearDown() {
        this.entityManager.clear();
    }

    @Test
    public void testfindByActivityAndMinutes() {
        entityManager.persist(exercise);
        Exercise byActivityAndMinutes = exerciseRepository.findByActivityAndMinutes(exercise.getActivity(), exercise.getMinutes());

        assertEquals(exercise.getActivity(), byActivityAndMinutes.getActivity());
        assertEquals(exercise.getMinutes(), byActivityAndMinutes.getMinutes());
    }

    @Test
    public void testfindByGoalAndActivity() {
        entityManager.persist(exercise);
        entityManager.persist(secondExercise);
        List<Exercise> byActivityAndMinutes = exerciseRepository.findByGoalAndActivity(goal, exercise.getActivity());

        assertEquals(exercise.getMinutes(), byActivityAndMinutes.get(0).getMinutes());
        assertEquals(secondExercise.getMinutes(), byActivityAndMinutes.get(1).getMinutes());
    }
}
