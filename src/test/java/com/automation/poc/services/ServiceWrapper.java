package com.automation.poc.services;


import com.automation.poc.services.exceptions.EndpointNotFoundException;
import com.automation.poc.services.thecatapi.TheCatApiBaseService;
import com.automation.poc.services.thecatapi.breeds.GetBreedsService;
import com.automation.poc.services.thecatapi.favourites.GetFavouriteService;
import com.automation.poc.services.thecatapi.favourites.GetFavouritesService;
import com.automation.poc.services.thecatapi.favourites.PostFavouritesService;
import com.automation.poc.services.thecatapi.images.GetImagesSearchService;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.ArrayList;
import java.util.List;

public class ServiceWrapper {

  private final List<RestService> services = new ArrayList<>();

  public ServiceWrapper() {
    List<TheCatApiBaseService> theCatApiBaseServices = List
        .of(new GetBreedsService(), new GetFavouritesService(), new GetImagesSearchService(),
            new PostFavouritesService(), new GetFavouriteService());
    services.addAll(theCatApiBaseServices);
  }

  public RequestSpecification getRequestSpecification(String bddEndpointId) {
    return this.services
        .stream()
        .filter(service -> service.getBddEndpointId().equals(bddEndpointId))
        .findFirst()
        .orElseThrow(() -> new EndpointNotFoundException(bddEndpointId))
        .getRequestSpecification();
  }

  public ResponseSpecification getResponseSpecification(String bddEndpointId) {
    return this.services
        .stream()
        .filter(service -> service.getBddEndpointId().equals(bddEndpointId))
        .findFirst()
        .orElseThrow(() -> new EndpointNotFoundException(bddEndpointId))
        .getResponseSpecification();
  }

}
