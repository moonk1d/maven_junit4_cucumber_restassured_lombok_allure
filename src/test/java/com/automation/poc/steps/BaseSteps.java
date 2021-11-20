package com.automation.poc.steps;

import static com.automation.poc.context.TestContext.CONTEXT;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.automation.poc.services.ServiceWrapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.File;
import org.junit.Assert;

public class BaseSteps {

  protected ServiceWrapper serviceWrapper = new ServiceWrapper();

  @Given("^\\[(.*)\\] request specification is built$")
  public void prepareRequestSpecification(String endpoint) {
    CONTEXT.setRequest(given(getReqSpecForEndpoint(endpoint)));
    CONTEXT.setResponseSpec(getRespSpecForEndpoint(endpoint));
  }

  @When("^I send (GET|POST|PUT|PATCH|DELETE|POST MULTIPART) request$")
  public void sendRequest(String method) {
    switch (method) {
      case "GET":
        CONTEXT.setResponse(
            CONTEXT.getRequest().when().get().then().spec(CONTEXT.getResponseSpec()));
        break;
      case "POST":
        CONTEXT.setResponse(CONTEXT
            .getRequest()
            .when()
            .body(CONTEXT.getRequestBody())
            .post()
            .then()
            .spec(CONTEXT.getResponseSpec()));
        break;
      case "POST MULTIPART":
        CONTEXT.setResponse(
            CONTEXT.getRequest().when().post().then().spec(CONTEXT.getResponseSpec()));
        break;
      case "PUT":
        CONTEXT.setResponse(CONTEXT
            .getRequest()
            .when()
            .body(CONTEXT.getRequestBody())
            .put()
            .then()
            .spec(CONTEXT.getResponseSpec()));
        break;
      case "PATCH":
        CONTEXT.setResponse(CONTEXT
            .getRequest()
            .when()
            .body(CONTEXT.getRequestBody())
            .patch()
            .then()
            .spec(CONTEXT.getResponseSpec()));
        break;
      case "DELETE":
        CONTEXT.setResponse(
            CONTEXT.getRequest().when().delete().then().spec(CONTEXT.getResponseSpec()));
        break;
      default:
        throw new RuntimeException(String.format("None-existing method [%s] provided.", method));
    }
  }

  @When("^I set pathParam \"([^\"]*)\" as \"([^\"]*)\"$")
  public void setPathParamAs(String pathParam, String pathParamValue) {
    CONTEXT.setRequest(CONTEXT.getRequest().pathParam(pathParam, pathParamValue));
  }

  @When("^I set queryParam \"([^\"]*)\" as \"([^\"]*)\"$")
  public void setQueryParamAs(String queryParam, String queryParamValue) {
    CONTEXT.setRequest(CONTEXT.getRequest().queryParam(queryParam, queryParamValue));
  }

  @When("^I set header \"([^\"]*)\" as \"([^\"]*)\"$")
  public void setHeaderAs(String header, String headerValue) {
    CONTEXT.setRequest(CONTEXT.getRequest().header(header, headerValue));
  }

  @When("^I set pathParam \"([^\"]*)\" as saved \"([^\"]*)\" value$")
  public void setPathParamAsSavedValue(String pathParam, String key) {
    CONTEXT.setRequest(CONTEXT.getRequest().pathParam(pathParam, CONTEXT.get(key)));
  }

  @When("^I set queryParam \"([^\"]*)\" as saved \"([^\"]*)\" value$")
  public void setQueryParamAsSavedValue(String queryParam, String key) {
    CONTEXT.setRequest(
        CONTEXT.getRequest().queryParam(queryParam, String.valueOf(CONTEXT.get(key))));
  }

  @When("^I remove \"([^\"]*)\" header$")
  public void removeHeader(String headerName) {
    FilterableRequestSpecification filterableReqSpec =
        (FilterableRequestSpecification) CONTEXT.getRequest();
    RequestSpecification reqSpec = filterableReqSpec.removeHeader(headerName);
    CONTEXT.setRequest(reqSpec);
    CONTEXT.setResponseSpec(new ResponseSpecBuilder().build());
  }

  @When("^I set saved file \"([^\"]*)\" as form data$")
  public void setSavedImportFileAsMultiPart(String fileName) {
    CONTEXT.setRequest(CONTEXT.getRequest().multiPart("file", (File) CONTEXT.get(fileName)));
  }

  @Then("^Response status code is (\\d+)$")
  public void validateResponseCode(Integer statusCode) {
    CONTEXT.setResponse(CONTEXT.getResponse().statusCode(statusCode));
  }

  @Then("^Response Content Type is (.*)$")
  public void validateResponseContentType(String contentType) {
    CONTEXT.setResponse(CONTEXT.getResponse().contentType(contentType));
  }

  @Then("^Response corresponds to \"([^\"]*)\" json schema$")
  public void responseCorrespondsToSchema(String schemaName) {
    CONTEXT.getResponse().body(matchesJsonSchemaInClasspath("schemas/" + schemaName));
  }

  @Then("Response size is equal to {int}")
  public void responseSizeIsEqualTo(int size) {
    int actualSize = CONTEXT.getResponse().extract().jsonPath().getList("").size();
    assertEquals(size, actualSize);
  }

  @Then("^Response message is (.+)")
  public void responseMessageIs(String message) {
    assertThat(CONTEXT.getResponse().extract().jsonPath().getString("message"))
        .isEqualTo(message);
  }

  protected RequestSpecification getReqSpecForEndpoint(String endpoint) {
    return serviceWrapper.getRequestSpecification(endpoint);
  }

  protected ResponseSpecification getRespSpecForEndpoint(String endpoint) {
    return serviceWrapper.getResponseSpecification(endpoint);
  }

}
