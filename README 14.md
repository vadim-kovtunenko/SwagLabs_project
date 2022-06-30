
# *Домашнее задание № 14*

## 1. Команда для обновления версий всех библиотек проекта:

**mvn versions:display-dependency-updates** *-команда для просмотра доступных обновлений библиотек*

>[INFO] The following dependencies in Dependencies have newer versions:  
[INFO]   io.github.bonigarcia:webdrivermanager ................. 5.1.1 -> 5.2.0  
[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.2.2   
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.6.0

**mvn versions:use-latest-versions**  *- команда для автоматического обновления всех версий*

>[INFO] Major version changes allowed  
[INFO] Updated org.testng:testng:jar:7.1.0 to version 7.6.0  
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.2.2  
[INFO] Updated io.github.bonigarcia:webdrivermanager:jar:5.1.1 to version 5.2.0  
[INFO] BUILD SUCCESS

## 2. Команда для запуска тестов используя mvn clean test:

**mvn clean test -DsuiteXmlFile=src/test/resources/ParametersLogin.xml** 

>[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.694 s - in TestSuite

## 3. Команды для запуска конкретных тестов и методов:

**mvn -Dtest=TestLogin#testLockedOutUser test**

>[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.597 s - in com.saucedemo.tests.TestLogin

__mvn "-Dtest=TestLogin#testLockedOutUser,TestCart#testAdd*Item" test__

>[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.453 s - in TestSuite

## 4. Команда для пробрасывания параметра из mvn command line внутрь теста:

**mvn -Dtest=TestCMDParameter -Dparameter=performance_glitch_user test**

>[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.677 s - in com.saucedemo.tests.TestCMDParameter
