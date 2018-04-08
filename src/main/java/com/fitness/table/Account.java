package com.fitness.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="ACCOUNT")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Account extends Auditable<String> implements Serializable {      // owning entity

    @Id
    @GeneratedValue
    @Column(name="ACCOUNT_ID")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)          // Owning entity for user_id
    @JoinTable(name = "USER_ACCOUNT", joinColumns=@JoinColumn(name = "ACCOUNT_ID"),
       inverseJoinColumns =@JoinColumn(name = "USER_ID"))
    private Set<User> users = new HashSet<>();

//    @OneToMany(cascade = CascadeType.ALL , mappedBy = "account")
//    List<Transaction> transactions= new ArrayList<>();

    @Column(name="ACCOUNT_NAME")
    private String name;

    @Column(name="INITIAL_BALANCE")
    private BigDecimal initialBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }
}
