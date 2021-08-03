# testProject

This is a sample project to demonstrate Page Object Model web automation and restassured REST api automation.

- Dependency Management - Maven
- Design Pattern - POM
- Testing Framework - TestNG
- Programming language - Java
- Libraries - restassured 

## Usage

```
git clone https://github.com/siri0603/testProject.git
cd testProject
add the Amazon credentials to config.properties file
# to run web test suite
mvn clean test -Dxml=testngSuites/webAutomation.xml

#to run REST API test suite
mvn clean test -Dxml=testngSuites/apiAutomation.xml
