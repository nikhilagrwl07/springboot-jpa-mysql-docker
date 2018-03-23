package com.fitness.dto;

import com.fitness.table.Credential;
import com.fitness.table.User;
import lombok.*;


@NoArgsConstructor
public class CredentialDTO {
    Credential credential;
    User user;

    public CredentialDTO(Credential credential, User user) {
        this.credential=credential;
        this.user=user;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
