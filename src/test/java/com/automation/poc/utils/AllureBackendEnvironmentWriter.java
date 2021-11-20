package com.automation.poc.utils;

import static java.lang.System.getProperty;
import static java.util.Optional.ofNullable;

import com.automation.poc.configuration.BackendConfiguration;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class AllureBackendEnvironmentWriter {

  private static final String PROPERTIES_PATH = "build/allure-results/environment.properties";

  public static void writeEnvironment() {

    try (FileOutputStream fos = new FileOutputStream(PROPERTIES_PATH);) {
      Properties props = new Properties();

      ofNullable(getProperty("env")).ifPresent(s -> props.setProperty("Environment:", s));
      props.setProperty("The cat api service:",
          BackendConfiguration.getEnvironment().getApiServiceBaseUrl());
      props.store(fos, "Writing properties to output stream");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
