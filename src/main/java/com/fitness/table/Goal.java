package com.fitness.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "GOAL")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Goal extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="GOAL_ID")
    private Long id;

    @Range(min = 1, max = 120)
    @Column(name="MINUTES")
    private int minutes;

    @Column(name="GOAL_NAME")
    private String goalname;

    @OneToMany(mappedBy = "goal",cascade = CascadeType.ALL)
    private List<Exercise> exercises = new ArrayList<>();

//    @OneToOne(mappedBy = "goal") // for bidirectional can remove it
//    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getGoalname() {
        return goalname;
    }

    public void setGoalname(String goalname) {
        this.goalname = goalname;
    }


}

