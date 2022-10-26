package com.alla.ebankservice.repositories;

import com.alla.ebankservice.entities.Account;
import com.alla.ebankservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface AccountRepository extends JpaRepository<Account,String > {
    @RestResource(path = "/byType")
List<Account> findByType(@Param("t") AccountType type);
}
