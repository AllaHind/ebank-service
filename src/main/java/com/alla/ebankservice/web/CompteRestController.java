package com.alla.ebankservice.web;

import com.alla.ebankservice.entities.Compte;
import com.alla.ebankservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class CompteRestController {

    private CompteRepository compteRepository;

    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("/accounts")
    public List<Compte> AccountList()
    {
        return compteRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Compte getCompte(@PathVariable("id") String id)
    {
        return compteRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found",id)));

    }
    @PostMapping("/accounts")
    public Compte saveAccount(@RequestBody Compte compte)
    {    compte.setId(UUID.randomUUID().toString());
        return compteRepository.save(compte);
    }
    @PutMapping("/accounts/{id}")
    public Compte updateAccount(@RequestBody Compte compte,@PathVariable String id)
    { Compte compte1=compteRepository.findById(id).orElseThrow(()->
            new RuntimeException(String.format("Account %s not found",id)));
        if(compte.getType()!=null) compte1.setType(compte.getType());
        if(compte.getBalance()!=null)  compte1.setBalance(compte.getBalance());
        if(compte.getCreatedAt()!=null)  compte1.setCreatedAt(new Date());
        if(compte.getCurrency()!=null)  compte1.setCurrency(compte.getCurrency());

        return compteRepository.save(compte1);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable String id)
    {
         compteRepository.deleteById(id);
    }
}
