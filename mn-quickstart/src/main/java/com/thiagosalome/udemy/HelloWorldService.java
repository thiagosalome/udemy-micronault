package com.thiagosalome.udemy;

import jakarta.inject.Singleton;

@Singleton // This annotation says that this class will be a singleton, so it will be instantiated only once
public class HelloWorldService implements MyService {
  
  @Override
  public String helloFromService () {
    return "Hello from service!";
  }
}
