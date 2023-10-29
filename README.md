# TestProjectSmallWorldFS


This Selenium Maven Java project demonstrates automated testing of a login page and add to cart and remove items from cart functionality using Cucumber BDD framework.

## Prerequisites

Make sure you have the following installed on your system:

- Java Development Kit (JDK)
- Maven
- IDE (Eclipse) with Cucumber and TestNG plugins installed (for editing feature files and running tests)

## Getting Started

1. **Configure Feature File Paths:**

Open the TestRunner.java class located in src/test/java/TestRunner directory. Update the features parameter in the @CucumberOptions annotation with the correct path to your feature files.

@CucumberOptions(features = "src/test/resources/features", // Update this path
                 // other options...)
public class TestRunner {
    // ...
}

2. Configure config.properties:
Copy the path of config.properties file located in src/test/resources/config. Then Open the ConfigReader.java file and update the FileInputStream with the correct path.

	FileInputStream ip = new FileInputStream("Update this path according to config.properties path");

**Note:** Please make sure that cucumber.properties file contains only browser = chrome value 
Because when i downloaded this project this file is automatically changed the data inside.

3. **Run Tests on Eclipse:**

Right-click on the TestRunner class.
Select "Run As" > "TestNG Test".
Make sure you have the Cucumber and TestNG plugins installed in Eclipse for the appropriate context menu options.
