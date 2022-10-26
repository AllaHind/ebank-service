package com.alla.ebankservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Account.class,name = "p")
public interface AccountProjection {

  public  String getId();
   public Double getBalance();
}
