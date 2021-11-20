package com.automation.poc.services.thecatapi.favourites;

import com.automation.poc.requests.CreateFavouriteRequest;
import com.automation.poc.services.thecatapi.TheCatApiBaseService;

public final class PostFavouritesService extends TheCatApiBaseService {

  private static final String PATH = "favourites";
  private static final String HTTP_METHOD = "POST";

  @Override
  public String getEndpointPath() {
    return PATH;
  }

  @Override
  public String getHttpMethod() {
    return HTTP_METHOD;
  }

  public CreateFavouriteRequest createFavourites(String imageId) {
    return CreateFavouriteRequest.builder()
        .imageId(imageId)
        .build();
  }
}
