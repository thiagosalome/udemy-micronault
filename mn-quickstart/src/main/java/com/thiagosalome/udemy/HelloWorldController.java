package com.thiagosalome.udemy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
// import jakarta.inject.Inject;

@Controller("/hello")
public class HelloWorldController {

  private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
  private final String helloFromConfig;
  private final HelloWorldTranslationConfig translationConfig;
  
  // Constructor Based Dependency Injection
  private final HelloWorldService helloWorldService;
  public HelloWorldController(HelloWorldService helloWorldService, @Property(name = "hello.world.message") String helloFromConfig, HelloWorldTranslationConfig translationConfig) {
    this.helloWorldService = helloWorldService;
    this.helloFromConfig = helloFromConfig;
    this.translationConfig = translationConfig;
  }

  // Annotation Based Dependency Injection
  // @Inject
  // private HelloWorldService helloWorldService;

  /* Annotation Based Dependency Injection using interface. 
      This is the best way to do it because it allows us to change the implementation of the service without changing the controller
      In compiled time, the compiler will inject the implementation of the interface that is annotated with @Singleton (HelloWorldService)
  */
  // @Inject
  // private MyService helloWorldService;


  @Get(
    produces = MediaType.TEXT_PLAIN // Specifies the response type. Its the default
  )
  public String helloWorld() {
    LOG.info("Called the Hello World API");
    return helloWorldService.helloFromService();
  }

  @Get(
    uri = "/config",
    produces = MediaType.TEXT_PLAIN
  )
  public String helloConfig(){
    LOG.debug("Return the message from the config file");
    return helloFromConfig;
  }

  @Get(
    uri = "/translation",
    produces = MediaType.APPLICATION_JSON // Returns a JSON Object
  )
  public HelloWorldTranslationConfig helloTranslation() {
    return translationConfig;
  }
}
