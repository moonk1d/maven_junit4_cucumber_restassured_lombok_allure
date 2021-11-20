package com.automation.poc.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BackendConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(BackendConfiguration.class);
  private static BackendEnvironment environment;

  public static BackendEnvironment getEnvironment() {
    return environment;
  }

  public static void initialize() {
    setupEnvironment();
  }

  private static void setupEnvironment() {
    String envProperty = System.getProperty("env");

    if (envProperty == null) {
      envProperty = "default";
    }

    switch (envProperty) {
      case "qa":
        environment = BackendEnvironment.QA;
        break;
      case "dev":
        environment = BackendEnvironment.DEV;
        break;
      default:
        environment = BackendEnvironment.DEV;
        break;
    }

    logger.info(String.format("Environment passed [%s]", environment));
  }
}
