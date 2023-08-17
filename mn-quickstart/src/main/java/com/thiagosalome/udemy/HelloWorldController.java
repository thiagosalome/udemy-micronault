package com.thiagosalome.udemy;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/hello")
public class HelloWorldController {
  
  // Constructor Based Dependency Injection
  // private final HelloWorldService helloWorldService;
  // public HelloWorldController(HelloWorldService helloWorldService) {
  //   this.helloWorldService = helloWorldService;
  // }

  // Annotation Based Dependency Injection
  // @Inject
  // private HelloWorldService helloWorldService;

  /* Annotation Based Dependency Injection using interface. 
      This is the best way to do it because it allows us to change the implementation of the service without changing the controller
      In compiled time, the compiler will inject the implementation of the interface that is annotated with @Singleton (HelloWorldService)
  */
  @Inject
  private MyService helloWorldService;


  @Get(
    produces = MediaType.TEXT_PLAIN // Specifies the response type. Its the default
  )
  public String helloWorld() {
    return helloWorldService.helloFromService();
  }
}
