package com.fitness.service;

import com.fitness.dto.UserDTOWithAccount;
import com.fitness.table.Account;

import java.util.List;

public interface AccountService {
    void save(UserDTOWithAccount UserDTOWithAccount);

    List<Account> getAllAccount();
}
