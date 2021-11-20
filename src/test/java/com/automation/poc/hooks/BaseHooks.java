package com.automation.poc.hooks;

import static com.automation.poc.context.TestContext.CONTEXT;

import com.automation.poc.configuration.BackendConfiguration;
import io.cucumber.java.Before;

/**
 * This Before hooks are required only for test runs from IDE and Cucumber plugin.
 */
public final class BaseHooks {

  @Before("@BackEnd")
  public void initializationBackend() {
    BackendConfiguration.initialize();
    CONTEXT.reset();
  }
}
