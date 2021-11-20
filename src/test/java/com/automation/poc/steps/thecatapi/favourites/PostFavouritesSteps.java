package com.automation.poc.steps.thecatapi.favourites;

import static com.automation.poc.context.TestContext.CONTEXT;

import com.automation.poc.requests.CreateFavouriteRequest;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
import java.util.Map;

public class PostFavouritesSteps {

  @DataTableType
  public CreateFavouriteRequest createFavouriteRequestEntry(Map<String, String> entry) {
    return CreateFavouriteRequest.builder()
        .imageId(entry.get("image_id"))
        .build();
  }

  @When("^I create favourites request$")
  public void createFavouriteRequest(CreateFavouriteRequest request) {
    CONTEXT.setRequestBody(request);
  }

}
