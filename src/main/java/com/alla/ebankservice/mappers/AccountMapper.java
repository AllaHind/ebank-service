package com.alla.ebankservice.mappers;

import com.alla.ebankservice.dto.BankAccountRequestDTO;
import com.alla.ebankservice.dto.BankAccountResponseDTO;
import com.alla.ebankservice.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
        public BankAccountResponseDTO fromBankAccount(Account account) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
         BeanUtils.copyProperties(account,bankAccountResponseDTO);
         return  bankAccountResponseDTO;
    }


    public Account toBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(bankAccountRequestDTO,account);
        return  account;
    }
}
