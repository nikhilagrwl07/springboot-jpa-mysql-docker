package com.fitness.table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CREDENTIAL")
@NoArgsConstructor
@AllArgsConstructor
public class Credential extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    @OneToOne(mappedBy = "credential",fetch = FetchType.LAZY) // for bidirectional
    @JsonIgnore
    public User user;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

    public Credential(User user, String username, String password) {
        this.user = user;
        this.username = username;
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
