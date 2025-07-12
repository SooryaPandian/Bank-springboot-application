package com.Bank.Account.Bank.DTO;

import com.Bank.Account.Bank.Entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {
    private String userName;
    private String password;
    private String accountHolderName;
    private String bankName;
    private String accountNumber;
    private String accountRemark;

    public Account toAccount() {
        return new Account(this.userName, this.password, this.accountHolderName, this.bankName, this.accountNumber, this.accountRemark);
    }
}
