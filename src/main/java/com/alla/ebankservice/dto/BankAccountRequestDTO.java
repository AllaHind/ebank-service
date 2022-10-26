package com.alla.ebankservice.dto;

import com.alla.ebankservice.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;


@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {

    private String currency;
    private Double balance;
    private AccountType type;
}
