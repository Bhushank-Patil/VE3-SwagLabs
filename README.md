
# VE3-SwagLabs

VE3-SwagLabs is an automated testing framework designed for testing web applications, utilizing the SwagLabs application as a reference.

## Table of Contents

* [Project Overview](#project-overview)
* [Technologies Used](#technologies-used)
* [Project Structure](#project-structure)
* [Setup Instructions](#setup-instructions)
* [Running Tests](#running-tests)
* [Reports](#reports)
* [Contributing](#contributing)
* [License](#license)

## Project Overview

This project aims to provide a robust framework for automated testing of web applications, ensuring functionality, performance, and security.

## Technologies Used

* **Java**: Primary programming language.
* **Selenium WebDriver**: For browser automation.
* **TestNG**: For test configuration and execution.
* **Maven**: For project management and dependency resolution.
* **ExtentReports**: For generating detailed test reports.

## Project Structure

The project follows a standard Maven directory structure:

```

VE3-SwagLabs/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── ve3/
│   │               └── swaglabs/
│   │                   ├── base/
│   │                   ├── pages/
│   │                   ├── tests/
│   │                   └── utils/
│   └── test/
│       └── java/
│           └── com/
│               └── ve3/
│                   └── swaglabs/
│                       └── tests/
├── .settings/
├── reports/
├── .classpath
├── .project
├── pom.xml
└── README.md
```



* **src/main/java/com/ve3/swaglabs**: Contains the main application code.

  * **base/**: Base classes for setting up and tearing down tests.
  * **pages/**: Page object models representing different pages of the application.
  * **tests/**: Test classes containing test cases.
  * **utils/**: Utility classes for common functions.
* **.settings/**: Eclipse IDE settings.
* **reports/**: Generated test reports.
* **.classpath**: Classpath settings for the project.
* **.project**: Project metadata.
* **pom.xml**: Maven project configuration.
* **README.md**: This file.

## Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Bhushank-Patil/VE3-SwagLabs.git
   cd VE3-SwagLabs
   ```



2. **Install Dependencies**

   Ensure you have [Maven](https://maven.apache.org/) installed. Then, run:

   ```bash
   mvn install
   ```



3. **Configure WebDriver**

   Download the appropriate WebDriver for your browser:

   * **Chrome**: [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
   * **Firefox**: [GeckoDriver](https://github.com/mozilla/geckodriver/releases)

   Place the WebDriver executable in a directory included in your system's PATH, or specify its location in your test configuration.

## Running Tests

To run the tests, use the following Maven command:

```bash
mvn test
```



TestNG will execute the tests, and results will be displayed in the console.

## Reports

After test execution, detailed reports can be found in the `reports/` directory.

