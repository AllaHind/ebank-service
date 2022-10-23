package com.alla.ebankservice;

import com.alla.ebankservice.entities.Compte;
import com.alla.ebankservice.enums.AccountType;
import com.alla.ebankservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);



    }
@Bean
CommandLineRunner start(CompteRepository compteRepository){

        return (args -> {
            for(int i=0;i<5;i++)
            {
                Compte compte=Compte.builder().id(
                        UUID.randomUUID().toString())
                        .type(Math.random()>0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*9000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();

                compteRepository.save(compte);

            }
        });


    }

}
