package com.automation.poc.configuration;

public enum BackendEnvironment {
  DEV("https://api.thecatapi.com/v1", "636b6451-612d-4c57-8622-166eddd650ab"),
  QA("url_placeholder", "api_key_placeholder");

  private String apiServiceBaseUrl;
  private String apiKey;

  BackendEnvironment(String apiServiceBaseUrl, String apiKey) {
    this.apiServiceBaseUrl = apiServiceBaseUrl;
    this.apiKey = apiKey;
  }

  public String getApiServiceBaseUrl() {
    return apiServiceBaseUrl;
  }

  public String getApiKey() {
    return apiKey;
  }
}
