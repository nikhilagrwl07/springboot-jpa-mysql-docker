package com.fitness.request;

import com.fitness.table.Credential;
import com.fitness.table.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialRequest {
    private String username;
    private String password;
    private String firstName;
}
