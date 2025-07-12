package com.Bank.Account.Bank.Repository;

import com.Bank.Account.Bank.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Account, Integer> {
    Account findByAccountHolderName(String name);
    Account findByUserName(String name);
    Account findByUserNameAndPassword(String userName, String password);
}
