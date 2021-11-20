package com.automation.poc.steps.thecatapi.images;

import static com.automation.poc.context.TestContext.CONTEXT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.automation.poc.pojo.Image;
import io.cucumber.java.en.Then;

public class GetImagesSearchSteps {

  @Then("^Images mime_type is (jpg|png|gif)$")
  public void imagesMimeTypeIs(String mimeType) {
    CONTEXT.getResponse()
        .extract()
        .jsonPath()
        .getList("url", String.class)
        .forEach(url -> assertThat(url).endsWith(mimeType));
  }

  @Then("^Response does/doesn't contains breeds in Response base on (.*)$")
  public void responseContainsBreeds(Boolean includeBreeds) {
    CONTEXT.getResponse()
        .extract()
        .jsonPath()
        .getList("$", Image.class)
        .forEach(
            image -> assertThat(image.getBreeds() != null).isEqualTo(includeBreeds));
  }

}
