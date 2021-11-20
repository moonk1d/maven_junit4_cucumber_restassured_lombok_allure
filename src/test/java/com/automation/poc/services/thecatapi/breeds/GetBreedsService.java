package com.automation.poc.services.thecatapi.breeds;

import com.automation.poc.services.thecatapi.TheCatApiBaseService;

public final class GetBreedsService extends TheCatApiBaseService {

  private static final String PATH = "breeds";
  private static final String HTTP_METHOD = "GET";

  @Override
  public String getEndpointPath() {
    return PATH;
  }

  @Override
  public String getHttpMethod() {
    return HTTP_METHOD;
  }
}
