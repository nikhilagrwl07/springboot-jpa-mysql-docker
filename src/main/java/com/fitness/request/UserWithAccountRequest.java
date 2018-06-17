package com.fitness.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class UserWithAccountRequest {
    String userName;
    String accountName;
    BigDecimal initialBalance;
}
