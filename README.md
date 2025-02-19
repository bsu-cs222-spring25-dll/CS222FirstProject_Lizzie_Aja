# Wikipedia Data Fetcher
## Project Summary:

This project catches and displays data of a Wikipedia article history using the program Java. It gets data from the “wikiWebsiteConnection”,"wikiFormatRevisions", "wikiMenu","wikiRevisionParser", "wikiUser", & "wikiWebsiteConnection", processes it using JSONPAth and the data proceeds to run by using the “main” class. The data is displayed in test run box, passing all tests and being able to type the articles name and proceeds to print out timestamps of the article, also ended making a GUI menu by implementing JavaFX, providing a more humanly description option. 

## Authors:
- **Aja Moore**
- **Lizzie Collins**

## Program That Were Used
- Java 11+
- Gradle
- JSONPath
- JUnit 5

## Expected Output 1 (Redirected Article):
```
****Enter a Wiki Article Name to get the most recent updates to the article.****
Zappa
Redirected to Frank Zappa
1   2025-01-15T04:27:54Z     CTCchurros  
2   2025-01-17T04:55:15Z     Ghost writer's cat  
3   2025-01-19T14:25:33Z     193.207.164.106  
```

## Expected Output 2(Error Article)
```
****Enter a title you would like revisions about.****
no article name
No Wikipedia article could be found!
```
## Expected Output 3(Connection Error)
```
***Enter a title you would like revisions about: Zappa***

There seems to be a network error!
```

## Expected Output 4(Normal Article)
```
****Enter a Wiki Article Name to get the most recent updates to the article.****
Elizabeth
1   2023-07-06T08:57:12Z     Rodw  
2   2023-07-06T12:45:10Z     Leschnei  
3   2023-08-02T10:37:48Z     Norgwendoll  
```

## Builds That Were Used
- Java 11
- Gradle

## How To Run the Program
1.	Clone the Repository from GitHub
2.	Open the project on IntelliJ IDEA Community Edition
3.	Click Clone Repository and paste in this link. (https://github.com/bsu-cs222-spring25dll/CS222FirstProject_Lizzie_Aja.git)
4.	Navigate to the “main” class and run the project from there! 

## All Testing Classes
If you would like to run each test individual, go inside IntelliJ -> click the drop-down arrow of the test folder -> click on a test -> and click on the green play button to run one. 

## GUI Connections (How To Run The GUI Menu)
1. Make sure to download JavaFx that supports your computer
2. Once you download it, implement it into your Intellij IDEA
3. After that, navigate to our wikiGui class and select the green play button at the top of the screen and get started!


## Resources That Were Used 

- Stack Overflow - Terminating a Java Program (https://stackoverflow.com/questions/22452930/terminating-a-java-program)
- W3Schools - Java Error Handling (https://www.w3schools.com/java/java_ref_errors.asp)
- Maven Repository - JSONPath (https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path/2.9.0)
- Goessner - JSONPath (https://goessner.net)
- JSONPath Testing Tool (https://jsonpath.com)
- JSONPath GitHub Repository (https://github.com/json-path/JsonPath)
- JavaFX (https://openjfx.io)
- Wikipedia (https://www.wikipedia.org)

