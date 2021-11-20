package com.automation.poc.context;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;
import java.util.Map;

public enum TestContext {

  CONTEXT;

  private static final String REQUEST = "REQUEST";
  private static final String REQUEST_BODY = "REQUEST_BODY";
  private static final String RESPONSE = "RESPONSE";
  private static final String RESPONSE_SPEC = "RESPONSE_SPEC";
  private final ThreadLocal<Map<String, Object>> testContexts = ThreadLocal
      .withInitial(HashMap::new);

  public <T> T get(String name) {
    return (T) testContexts.get().get(name);
  }

  public <T> T get(String key, Class<T> objectClass) {
    Object object = testContexts.get().get(key);
    if (object == null) {
      throw new RuntimeException(String.format("Object with key [%s] not found.", key));
    }

    return objectClass.cast(object);
  }

  public <T> T set(String name, T object) {
    testContexts.get().put(name, object);
    return object;
  }

  public RequestSpecification getRequest() {
    return get(REQUEST);
  }

  public Object getRequestBody() {
    return get(REQUEST_BODY);
  }

  public ValidatableResponse getResponse() {
    return get(RESPONSE);
  }

  public ResponseSpecification getResponseSpec() {
    return get(RESPONSE_SPEC);
  }

  public void setResponse(ValidatableResponse response) {
    set(RESPONSE, response);
  }

  public void setRequest(RequestSpecification request) {
    set(REQUEST, request);
  }

  public <T> T setRequestBody(T requestBody) {
    return set(REQUEST_BODY, requestBody);
  }

  public void setResponseSpec(ResponseSpecification responseSpec) {
    set(RESPONSE_SPEC, responseSpec);
  }

  public void reset() {
    testContexts.get().clear();
  }
}
