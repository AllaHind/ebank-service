package com.alla.ebankservice.repositories;

import com.alla.ebankservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,String > {

}
