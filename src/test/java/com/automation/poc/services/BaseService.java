package com.automation.poc.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class BaseService implements RestService {

  protected RequestSpecification REQ_SPEC;
  protected ResponseSpecification RESP_SPEC;

  public BaseService() {
    this.REQ_SPEC = new RequestSpecBuilder()
        .setBasePath(getEndpointPath())
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .addFilter(new AllureRestAssured())
        .setContentType(ContentType.JSON)
        .build();

    this.RESP_SPEC = new ResponseSpecBuilder()
        .expectContentType(ContentType.JSON)
        .build();
  }

  /**
   * BddEndpointId will be provided in cucumber feature files, in appropriate steps, to build proper
   * request/response specification for endpoints identified by BddEndpointId.
   * <p>
   * BddEndpointId pattern: [EndpointHttpMethod + " " + ServicePath + "/" + EndpointPath]
   * <p>
   * example: [POST /entitlement-master-integration/entitlements]
   */
  public String getBddEndpointId() {
    return getHttpMethod() + " /" + getEndpointPath();
  }

  public abstract String getEndpointPath();

  public abstract String getHttpMethod();

  public abstract String getBaseUri();

  public RequestSpecification getRequestSpecification() {
    return REQ_SPEC;
  }

  public ResponseSpecification getResponseSpecification() {
    return RESP_SPEC;
  }

}
