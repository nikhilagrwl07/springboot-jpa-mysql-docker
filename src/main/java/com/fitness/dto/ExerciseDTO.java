package com.fitness.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {

    int minutes;
    String activity;
    String goalName;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }
}
