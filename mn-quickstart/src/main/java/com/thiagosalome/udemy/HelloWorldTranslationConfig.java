package com.thiagosalome.udemy;

import javax.validation.constraints.NotBlank;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("hello.world.translation")
public interface HelloWorldTranslationConfig {
  
  // Micronaut will inject the values from the application.yml file
  @NotBlank // Checks if the value is not blank
  String getBr();

  @NotBlank
  String getEn();

}
