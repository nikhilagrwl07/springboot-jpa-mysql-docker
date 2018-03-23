package com.fitness.repository;

import com.fitness.table.Exercise;
import com.fitness.table.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
    public Exercise findByActivityAndMinutes(String activity, int minutes);
    public List<Exercise> findByGoalAndActivity(Goal goal, String activity);
}
