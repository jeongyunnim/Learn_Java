package com.easybytes.accounts.mapper;

import com.easybytes.accounts.dto.AccountsDto;
import com.easybytes.accounts.entity.Accounts;

/**
 * entity to dto
 * dto to entity
 */
public class AccountsMapper {
    public static AccountsDto mapToAccountDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setAccountType(accounts.getAccountType());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setAccountType(accountsDto.getAccountType());
        return accounts;
    }
}
