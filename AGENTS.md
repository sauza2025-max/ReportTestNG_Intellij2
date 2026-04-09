# AGENTS.md

## Project Overview
This is a Maven-based Java project for cross-browser Selenium testing using TestNG. It demonstrates automated browser testing across Chrome, Firefox, and Edge, with a focus on TestNG reporting integration in IntelliJ IDEA.

## Architecture
- **Main Components**: Test classes in `src/test/java/org/example/`, configured via `testng.xml` for parameterized browser testing.
- **Data Flow**: TestNG suite parameters drive browser setup in `@BeforeMethod`, executing tests on BrowserStack's website.
- **Structural Decisions**: Separate test classes for cross-browser (`CrossBrowserTest`) and unit tests (`TestClass1`); reports generated in `target/surefire-reports/` and `test-output/`.

## Critical Workflows
- **Build**: `mvn clean compile` - compiles sources and tests.
- **Run Tests**: `mvn test` - executes TestNG suite from `testng.xml`, generating HTML/XML reports.
- **Debug Tests**: Run individual test methods in IntelliJ; use `@Parameters("browser")` for browser-specific debugging.
- **CI Integration**: Edge tests include headless options (`--headless=new`, `--no-sandbox`) for Jenkins/containers.

## Project Conventions
- **Browser Management**: Use `WebDriverManager` for automatic driver setup (e.g., `WebDriverManager.chromedriver().setup()` in `CrossBrowserTest.java`).
- **Test Parameters**: Define browser variants in `testng.xml` with `<parameter name="browser" value="chrome"/>`; inject via `@Parameters("browser")` in setup methods.
- **Assertions**: Use `Assert.assertEquals` for title verification, as in `verifyTitle()` method.
- **Driver Lifecycle**: Initialize `WebDriver` in `@BeforeMethod`, quit in test methods (e.g., `driver.quit()` at end of `verifyTitle`).
- **Test Isolation**: Each test suite run is independent; no shared state between browser tests.

## Integration Points
- **Dependencies**: Selenium 4.26.0 for WebDriver, TestNG 7.10.2 for framework, WebDriverManager 6.3.4 for driver management.
- **External Services**: Tests hit `https://www.browserstack.com/` for title assertion.
- **Reporting**: Surefire plugin generates emailable reports (`emailable-report.html`) and XML results (`testng-results.xml`).

## Key Files
- `pom.xml`: Maven config with Surefire plugin pointing to `testng.xml`.
- `testng.xml`: Suite definition with browser parameters for `CrossBrowserTest`.
- `src/test/java/org/example/CrossBrowserTest.java`: Parameterized browser setup and title test.
- `src/test/java/org/example/TestClass1.java`: Simple TestNG methods (not in suite).</content>
<parameter name="filePath">C:\Users\FE\eclipse-workspace\ReportTestNG_Intellij\AGENTS.md
