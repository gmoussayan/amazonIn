## Amazon India small automation test

This is a small automation Test Run using [amazon india](https://amazon.in). The test is built using **Selenium Java**, **TestNG** and **Maven**. It will run the follwing Test Cases.

+ The **selectSamsungTV**, which will repeat (1 more time) using IRetryAnalyzer, in case the test fails for unexpected conditions.

  - Open https://www.amazon.in
  - Click the top left **hamburger menu**. 
  - Scroll down and click **TV, Appliances and Electronics** under **Shop by Department** section. 
  - Click **Televisions** under **Tv, Audio & Cameras** sub section. 
  - Scroll down and filter the results by **Samsung** brand.
  - Sort the results with **Price: High to Low**.
  - Click the second highest priced item (whatever that may be at the time of automating).
  - Switch the Window, and Assert that “About this item” wordings are present and log it to console.

+ **iFailTestCase**, which will try to sign in with an invalid username and password, and intentionally failing the test to generate the HTML report.

+ **iSucceedTestCase**, which will run the same above steps without failing the test.

Soft Assert instead of Hard Assert is used, and a generated HTML report under reports folder will show the Test Run results.

### Getting Started
The following instructions will get you a copy of the repo to run it on your local machine.

- Download and install [Java](https://www.oracle.com/java/technologies/downloads/).
- Download and install [Maven](https://maven.apache.org/download.cgi).
- Set Java and Maven User variables.
- Clone the Repo to your local machine.
- From the project root directory, run the following command to run the test with Chrome browser (not headless):
```
mvn test -PRegression -Dbrowser=chrome
```
- From the project root directory, run the following command to run the test with headless Chrome:
```
mvn test -PRegression -Dbrowser=headlesschrome
```


notes:
- i will be digging later on into stabilizing some areas of the test, and add few more test cases.
- There are few other files not used in above run but can meanwhile be used to play around tests and TestNG Annotations.

#### Author

Georges
