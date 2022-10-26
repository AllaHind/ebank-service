package com.alla.ebankservice.services;

import com.alla.ebankservice.dto.BankAccountRequestDTO;
import com.alla.ebankservice.dto.BankAccountResponseDTO;
import com.alla.ebankservice.entities.Account;
import com.alla.ebankservice.enums.AccountType;

public interface AccountService {

    public BankAccountResponseDTO saveAccount(BankAccountRequestDTO bankAccountRequestDTO) ;

}
