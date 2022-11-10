## Amazon India small automation test

This is a small automation test using [amazon india](https://amazon.in). The main test **selectSamsungTV** will run the below steps:

- Open https://www.amazon.in
- Click the top left **hamburger menu**. 
- Scroll down and click **TV, Appliances and Electronics** under **Shop by Department** section. 
- Click **Televisions** under **Tv, Audio & Cameras** sub section. 
- Scroll down and filter the results by **Samsung** brand.
- Sort the results with **Price: High to Low**.
- Click the second highest priced item (whatever that may be at the time of automating).
- Switch the Window, and Assert that “About this item” wordings are present and log it to console.

The test is built using **Selenium Java**, **TestNG** and **Maven**

There are few others tests that are mainly used to play with TestNG Annotations.

### Getting Started
The following instructions will get you a copy of the test up and running on your local machine.

- Download and install [Java](https://www.oracle.com/java/technologies/downloads/)
- Download and install [Maven](https://maven.apache.org/download.cgi)
- Clone the Repo to your local machine
- From the project root directory, run the following command to run the test with Chrome browser (not headless):
```
mvn test -PRegression -Dbrowser=chrome
```
- From the project root directory, run the following command to run the test with headless Chrome:
```
mvn test -PRegression -Dbrowser=headlesschrome
```

#### Author

Georges
