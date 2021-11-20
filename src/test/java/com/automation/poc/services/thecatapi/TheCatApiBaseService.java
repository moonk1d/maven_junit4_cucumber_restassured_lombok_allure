package com.automation.poc.services.thecatapi;

import com.automation.poc.configuration.BackendConfiguration;
import com.automation.poc.services.BaseService;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class TheCatApiBaseService extends BaseService {

  private static final String API_KEY = BackendConfiguration.getEnvironment().getApiKey();
  private static final String BASE_URI = BackendConfiguration.getEnvironment().getApiServiceBaseUrl();

  public TheCatApiBaseService() {
    super();
  }

  public abstract String getEndpointPath();

  public abstract String getHttpMethod();

  public String getBaseUri() {
    return BASE_URI;
  }

  public RequestSpecification getRequestSpecification() {
    return super.getRequestSpecification().baseUri(BASE_URI).header("x-api-key", API_KEY);
  }

  public ResponseSpecification getResponseSpecification() {
    return RESP_SPEC;
  }

}
