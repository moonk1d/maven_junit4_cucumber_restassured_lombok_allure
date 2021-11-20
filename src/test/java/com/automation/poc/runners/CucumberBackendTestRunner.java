package com.automation.poc.runners;

import com.automation.poc.configuration.BackendConfiguration;
import com.automation.poc.utils.AllureBackendEnvironmentWriter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
    glue = {"com.automation.poc.steps"}

)
public class CucumberBackendTestRunner {

  @BeforeClass
  public static void init() {
    BackendConfiguration.initialize();
  }

  @AfterClass
  public static void tearDown() {
    AllureBackendEnvironmentWriter.writeEnvironment();
  }
}
