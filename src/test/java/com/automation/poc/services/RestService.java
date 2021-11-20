package com.automation.poc.services;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public interface RestService {

  String getEndpointPath();

  String getBddEndpointId();

  String getHttpMethod();

  RequestSpecification getRequestSpecification();

  ResponseSpecification getResponseSpecification();
}
