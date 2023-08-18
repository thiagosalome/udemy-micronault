package com.thiagosalome.udemy;

import jakarta.inject.Singleton;

@Singleton // This annotation says that this class will be a singleton, so it will be instantiated only once
public class SecondHelloWorldService implements MyService {
  
  @Override
  public String helloFromService () {
    return "Hello from second service!";
  }
}
