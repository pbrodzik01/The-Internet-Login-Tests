## The Internet Login Tests

UI test automation project built with Java, Selenium WebDriver, JUnit 5, and Maven.
This project was created as an introductory Selenium framework focused on login validation and basic test structure.
It was used as a starting point before building a larger e-commerce UI automation framework.

## Scope

- The project covers:
- valid login scenario
- invalid login scenario
- basic assertion of success and error messages
- screenshot capture on failed tests

Tested application:
- `https://the-internet.herokuapp.com/login`

## Tech Stack

- Java 17
- Selenium WebDriver
- JUnit 5
- Maven

## Framework Highlights
- simple Page Object Model structure
- reusable base test class
- failure screenshots
- clean separation of page and test logic
- good starter project for UI automation portfolio

## Project Structure

```text
src/test/java
├── base
├── extensions
├── pages
├── tests
└── utils
```

## Implemented Test Scenarios

- successful login with valid credentials
- error message for invalid password
- error message for invalid username

## Test Credentials

The demo site provides public test credentials:
- Username: `tomsmith`
- Password: `SuperSecretPassword!`

## Run Tests

Run all tests:
```
mvn test
```

Run in headless mode:
```
mvn test -Dheadless=true
```

## Failure Screenshots

Screenshots for failed tests are saved to:
```
target/screenshots
```

## What This Project Shows

This project demonstrates:
- basic Selenium test structure
- use of Page Objects
- writing positive and negative UI tests
- handling assertions in JUnit 5
- preparing a project for further framework expansion
## Future Improvements
- explicit waits with `WebDriverWait`
- parameterized tests
- Allure reporting
- GitHub Actions CI
- richer page abstractions

## Author
Patrycja Brodzik
