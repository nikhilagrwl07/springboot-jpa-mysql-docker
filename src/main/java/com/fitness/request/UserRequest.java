package com.fitness.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String goalName;
}
