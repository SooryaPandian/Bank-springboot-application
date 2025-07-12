package com.Bank.Account.Bank.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @Column(name = "account_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "account_holder_name", length = 50)
    private String accountHolderName;

    @Column(name = "bank_name", length = 50)
    private String bankName;

    @Column(name = "account_number", length = 50)
    private String accountNumber;

    @Column(name = "account_remark", length = 50)
    private String accountRemark;

    public Account(String accountHolderName, String bankName, String accountNumber, String accountRemark) {
        this.accountHolderName = accountHolderName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountRemark = accountRemark;
    }

    public Account(String userName, String password, String accountHolderName, String bankName, String accountNumber, String accountRemark) {
        this.userName = userName;
        this.password = password;
        this.accountHolderName = accountHolderName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountRemark = accountRemark;
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
