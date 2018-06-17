package com.fitness.repository;

import com.fitness.table.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GoalRepository extends JpaRepository<Goal,Long>{
    Goal findByGoalName(String goalName);
}
