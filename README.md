# Maven + jUnit4 + Cucumber + logback + RestAssured + AssertJ + Lombok + Allure reports

A sample maven base project which uses jUnit for running tests, Cucumber as BDD framework, logback
library for logging, RestAssured for API testing and Allure framework for reporting.

# To Run

* will run all the test inside `src/test/resources/features` on default 'dev' environment.
  ```shell
  $ mvn clean test -Dtest=CucumberBackendTestRunner
  ```
* will run all the test inside `src/test/resources/features` on qa environment.
  ```shell
  $ mvn clean test -Denv=qa -Dtest=CucumberBackendTestRunner
  ```

After the tests are run, you can see:

* Allure results `build/allure-results`

## To generate Allure report on local machine
1. [Allure CLI](https://docs.qameta.io/allure/#_commandline) should be installed
  - Download latest Allure zip package
  - Extract Allure zip package
  - Create `ALLURE_HOME` system variable with path to unpacked Allure directory
  - Add `%ALLURE_HOME%\bin` to `PATH` system variable
  - Verify that Allure setup is correct, run following command in command line:
    ```shell
    $ allure --version
    ```
1. Run command to generate report
   ```shell
   $ allure generate build/allure-results
   ```

## Cucumber configuration

* Glue or steps classes `src/com.automation.poc.steps`
* Feature files `src/resources/features`
* Cucumber property file `src/resources/cucumber.properties`
* Example of test runner `src/com.automation.poc.runners.CucumberBackendTestRunner`

## Logback configuration

You can find logback configuration here `src/test/resources/logback.xml`

Current configuration contains two appenders:

* ConsoleAppender will output logs to system out stream
* FileAppender will output logs to `build/logs/log.log`

## Framework configuration

### BackendConfiguration

This class makes generic configuration for the framework and allows us to run tests on different
environments by passing system property.

`mvn clean test -Denv=qa -Dtest=CucumberBackendTestRunner`

### AllureEnvironmentWriter

This class adds framework configuration details to "Environments" section of Allure report

### TestContext

Represents test run context storage which allows to save/get data and share it between test
cases/test classes during test run.

## Libraries Used

* [Junit](https://junit.org/junit4/) - 4.13
* [Maven](https://maven.apache.org/) - 3.8.4
* [Logback](http://logback.qos.ch/manual/index.html) - 1.2.3
* [Allure](https://docs.qameta.io/allure/) - 2.13.9
* [Cucumber](https://cucumber.io/docs/cucumber/) - 6.8.1
* [Allure-Cucumber](https://docs.qameta.io/allure/#_cucumber_jvm) - 2.13.9
* [RestAssured](https://rest-assured.io/) - 4.4.0
