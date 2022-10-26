package com.alla.ebankservice.web;

import com.alla.ebankservice.dto.BankAccountRequestDTO;
import com.alla.ebankservice.dto.BankAccountResponseDTO;
import com.alla.ebankservice.entities.Account;
import com.alla.ebankservice.repositories.AccountRepository;
import com.alla.ebankservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1")
public class AccountRestController {

    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<Account> AccountList()
    {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getCompte(@PathVariable("id") String id)
    {
        return accountRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found",id)));

    }
    @PostMapping("/accounts")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO)
    {
        return accountService.saveAccount(bankAccountRequestDTO);
    }
    @PutMapping("/accounts/{id}")
    public Account updateAccount(@RequestBody Account account, @PathVariable String id)
    { Account account1 = accountRepository.findById(id).orElseThrow(()->
            new RuntimeException(String.format("Account %s not found",id)));
        if(account.getType()!=null) account1.setType(account.getType());
        if(account.getBalance()!=null)  account1.setBalance(account.getBalance());
        if(account.getCreatedAt()!=null)  account1.setCreatedAt(new Date());
        if(account.getCurrency()!=null)  account1.setCurrency(account.getCurrency());

        return accountRepository.save(account1);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable String id)
    {
         accountRepository.deleteById(id);
    }

    }

