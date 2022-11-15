package com.alla.ebankservice.entities;

import com.alla.ebankservice.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Account {
    @Id
    private String id;
    private Double balance;
    private String currency;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

}
