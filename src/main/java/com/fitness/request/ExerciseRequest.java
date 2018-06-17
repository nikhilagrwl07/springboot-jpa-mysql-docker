package com.fitness.request;

import lombok.*;


@NoArgsConstructor
@Data
public class ExerciseRequest {
    int minutes;
    String activity;
    String goalName;
}
