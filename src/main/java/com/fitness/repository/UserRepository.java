package com.fitness.repository;

import com.fitness.table.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("simple-cache")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u " +
            "JOIN u.userProfile up WHERE up.phoneNumber = :phoneNumber")
    public User findUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Cacheable("alluserscache")
    public List<User> findAll();

    @Cacheable(cacheNames = "usercache",key = "{#firstName}")
    public User findUserByFirstName(String firstName);
}
