package com.Bank.Account.Bank.Service;

import com.Bank.Account.Bank.Entity.Account;
import com.Bank.Account.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private BankRepository repository;

    public boolean save(Account account) {
        if (repository.findByUserName(account.getUserName()) == null) {
            repository.save(account);
            return true;
        }

        System.out.println("User Already exists");
        return false;
    }

    public Account getAccountById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Account getAccountByName(String name) {
        return repository.findByAccountHolderName(name);
    }

    public Account login(String userName, String password) {
        return repository.findByUserNameAndPassword(userName, password);
    }

    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            System.out.println("Invalid id");
            return false;
        }
    }

    public String update(Account account) {
        Account existingAccount = repository.findById(account.getAccountId()).orElse(null);
        if (existingAccount != null) {
            existingAccount.setAccountHolderName(account.getAccountHolderName());
            existingAccount.setBankName(account.getBankName());
            existingAccount.setAccountNumber(account.getAccountNumber());
            existingAccount.setAccountRemark(account.getAccountRemark());
            repository.save(existingAccount);
            return "Modified Successfully";
        } else {
            return "Account Id doesn't Match";
        }
    }
}
