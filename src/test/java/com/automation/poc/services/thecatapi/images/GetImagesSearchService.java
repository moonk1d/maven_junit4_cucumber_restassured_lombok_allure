package com.automation.poc.services.thecatapi.images;

import com.automation.poc.services.thecatapi.TheCatApiBaseService;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class GetImagesSearchService extends TheCatApiBaseService {

  private static final String PATH = "images/search";
  private static final String HTTP_METHOD = "GET";

  @Override
  public ResponseSpecification getResponseSpecification() {
    return new ResponseSpecBuilder().build();
  }

  @Override
  public String getEndpointPath() {
    return PATH;
  }

  @Override
  public String getHttpMethod() {
    return HTTP_METHOD;
  }
}
