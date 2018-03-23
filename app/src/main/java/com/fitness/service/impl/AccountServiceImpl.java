package com.fitness.service.impl;

import com.fitness.dto.UserDTOWithAccount;
import com.fitness.repository.AccountRepository;
import com.fitness.repository.UserRepository;
import com.fitness.service.AccountService;
import com.fitness.table.Account;
import com.fitness.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service("userService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void save(UserDTOWithAccount userDTOWithAccount) {
        User user = userRepository.findOne(Long.valueOf(userDTOWithAccount.getFirstUserId()));

        if(user==null)
        {
            user = new User();
            user.setUserId((long) userDTOWithAccount.getFirstUserId());
        }

        User user2 = userRepository.findOne(Long.valueOf(userDTOWithAccount.getSecondUserId()));

        if(user2==null)
        {
            user2 = new User();
            user2.setUserId((long) userDTOWithAccount.getSecondUserId());
        }


        Account account = new Account();
        account.setInitialBalance(userDTOWithAccount.getInitialBalance());
        account.setName(userDTOWithAccount.getAccountName());


        user.getAccounts().add(account);
        user2.getAccounts().add(account);


        Set<User> users = account.getUsers();
        users.add(user);
        users.add(user2);
        account.setUsers(users);
        accountRepository.saveAndFlush(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
}
