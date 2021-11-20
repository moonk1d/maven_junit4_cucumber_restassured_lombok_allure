package com.automation.poc.services.thecatapi.favourites;

import com.automation.poc.services.thecatapi.TheCatApiBaseService;

public final class GetFavouriteService extends TheCatApiBaseService {

  private static final String PATH = "favourites/{favouriteId}";
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
