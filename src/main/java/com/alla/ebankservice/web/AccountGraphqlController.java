package com.alla.ebankservice.web;

import com.alla.ebankservice.dto.BankAccountRequestDTO;
import com.alla.ebankservice.dto.BankAccountResponseDTO;
import com.alla.ebankservice.entities.Account;
import com.alla.ebankservice.mappers.AccountMapper;
import com.alla.ebankservice.repositories.AccountRepository;
import com.alla.ebankservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Controller
public class AccountGraphqlController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<Account> accounts() {
        return accountRepository.findAll();
    }

    @QueryMapping
    public Account findAccount(@Argument String id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("account with  %s not found",id))
        );
    }

    @MutationMapping
    BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAcountDTO)
    {
        return  accountService.saveAccount(bankAcountDTO);
    }
   @MutationMapping
    public Account updateAccount(@Argument Account account, @Argument String id)
    { Account account1 = accountRepository.findById(id).orElseThrow(()->
            new RuntimeException(String.format("Account %s not found",id)));
        if(account.getType()!=null) account1.setType(account.getType());
        if(account.getBalance()!=null)  account1.setBalance(account.getBalance());
        if(account.getCreatedAt()!=null)  account1.setCreatedAt(new Date());
        if(account.getCurrency()!=null)  account1.setCurrency(account.getCurrency());

        return accountRepository.save(account1);
    }
    @MutationMapping
    Boolean deleteAccount(@Argument  String id)
    {
         accountRepository.deleteById(id);
         return true;
    }
}

