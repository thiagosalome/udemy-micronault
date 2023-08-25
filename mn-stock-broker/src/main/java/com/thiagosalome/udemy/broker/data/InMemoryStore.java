package com.thiagosalome.udemy.broker.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import com.thiagosalome.udemy.broker.Symbol;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;

@Singleton // We assure that we have only one instance of this class
public class InMemoryStore {

  private static final Logger LOG = LoggerFactory.getLogger(InMemoryStore.class);
  // The line below means that we have a map of String keys and Symbol values
  private final Map<String, Symbol> symbols = new HashMap<>();
  private final Faker faker = new Faker();

  @PostConstruct // This annotation means that this method will be executed after the constructor
  public void initialize() {
    IntStream.range(0, 10).forEach(i -> addNewSymbol());
  }

  private void addNewSymbol() {
    var symbol = new Symbol(faker.stock().nsdqSymbol()); // New Symbol instance
    symbols.put(symbol.value(), symbol); // Add the new Symbol instance to the map
    LOG.debug("Added Symbol {}", symbol); // Log the new Symbol instance
  }

  public Map<String, Symbol> getSymbols() {
    return this.symbols;
  }
}
