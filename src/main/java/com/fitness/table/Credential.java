package com.fitness.table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CREDENTIAL")
@NoArgsConstructor
public class Credential extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CREDENTIAL_ID")
    public Long credentialId;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID") // name is for source object and referencedColumnName is for target object
    @JsonIgnore
    public User user;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
