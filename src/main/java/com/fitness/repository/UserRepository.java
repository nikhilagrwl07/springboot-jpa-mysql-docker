package com.fitness.repository;

import com.fitness.table.Exercise;
import com.fitness.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<Exercise> findByUserId(Long userId);
}
