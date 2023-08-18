package com.thiagosalome.udemy;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Primary // This annotation says that this class will be the primary implementation of the interface MyService
@Singleton // This annotation says that this class will be a singleton, so it will be instantiated only once
public class HelloWorldService implements MyService {
  
  @Override
  public String helloFromService () {
    return "Hello from service!";
  }
}
