package com.automation.poc.services.exceptions;

public class EndpointNotFoundException extends RuntimeException {

  public EndpointNotFoundException(String bddEndpointId) {
    super(String.format("Endpoint [%s] not found.", bddEndpointId));
  }
}
