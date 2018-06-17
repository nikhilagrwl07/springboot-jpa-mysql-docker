package com.fitness.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="USER_ACCOUNT_DETAILS")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class UserAccountDetails extends Auditable<String> implements Serializable {      // owning entity

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="ACCOUNT_NAME")
    private String name;

    @Column(name="REMAINING_BALANCE")
    private BigDecimal remainingBalance;

    @Column(name="DEPOSITED_BALANCE")
    private BigDecimal depositedGymBalance;

    @OneToOne(mappedBy = "userAccountDetails",fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public BigDecimal getDepositedGymBalance() {
        return depositedGymBalance;
    }

    public void setDepositedGymBalance(BigDecimal depositedGymBalance) {
        this.depositedGymBalance = depositedGymBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

