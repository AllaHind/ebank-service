package com.alla.ebankservice.services;

import com.alla.ebankservice.dto.BankAccountRequestDTO;
import com.alla.ebankservice.dto.BankAccountResponseDTO;
import com.alla.ebankservice.entities.Account;
import com.alla.ebankservice.mappers.AccountMapper;
import com.alla.ebankservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;

    public BankAccountResponseDTO saveAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        Account account = accountMapper.toBankAccount(bankAccountRequestDTO);
        account.setId(UUID.randomUUID().toString());
        account.setCreatedAt(new Date());
        accountRepository.save(account);
        BankAccountResponseDTO savedAccount = accountMapper.fromBankAccount(account);
        return savedAccount;
    }
}
