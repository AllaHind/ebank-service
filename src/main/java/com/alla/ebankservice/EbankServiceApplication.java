package com.alla.ebankservice;

import com.alla.ebankservice.entities.Account;
import com.alla.ebankservice.entities.Customer;
import com.alla.ebankservice.enums.AccountType;
import com.alla.ebankservice.repositories.AccountRepository;
import com.alla.ebankservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);



    }
@Bean
CommandLineRunner start(AccountRepository accountRepository, CustomerRepository customerRepository){

        return args -> {
            Stream.of("Hind","Ibtissam","Kenza"
            ).forEach(c-> {
                Customer customer= Customer.builder().
                        nom(c).build();
                   customerRepository.save(customer);

        });
customerRepository.findAll().forEach(customer -> {
            for(int i=0;i<5;i++)
            {
                Account account = Account.builder().id(
                                UUID.randomUUID().toString())
                        .type(Math.random()>0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*9000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .customer(customer)
                        .build();

                accountRepository.save(account);

            }
        });


    };

}
}
