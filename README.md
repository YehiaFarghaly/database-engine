# Database-Engine
Database Engine that supports some features like:
- Creating a table
- Inserting into a table
- Updating a table
- Deleting from a table
- Selecting from a table
- Creating an Index -using Octree-
- Writing SQL queries
- Supported data types: **int** (java.lang.Integer), **double** (java.lang.Double), **date** (java.util.Date), **varchar** (java.lang.String)   
</br>

[![Java CI with Maven](https://github.com/YehiaFarghaly/Database-Engine/actions/workflows/maven.yml/badge.svg)](https://github.com/YehiaFarghaly/Database-Engine/actions/workflows/maven.yml)  
<div style="display: flex;">
  <img src="https://img.shields.io/badge/Apache-maven-%23C71A36?style=for-the-badge&logo=ApacheMaven" alt="Apache Maven badge">
  <img src="https://img.shields.io/badge/Github-Actions-%232088FF?style=for-the-badge&logo=GithubActions" alt="Github Actions badge">
  <img src="https://img.shields.io/badge/Junit5-tests-%2325A162?style=for-the-badge&logo=Junit5" alt="Junit 5 badge">
  <img src="https://img.shields.io/badge/Git--%23F05032?style=for-the-badge&logo=Git" alt="Git badge">
  <img src="https://img.shields.io/badge/-Github-%23181717?style=for-the-badge&logo=Github" alt="Github badge">
  <img src="https://img.shields.io/badge/-Dependabot-%23025E8C?style=for-the-badge&logo=Dependabot" alt="Dependabot badge">
  <img src="https://img.shields.io/badge/-Checkstyle-%234c6ef5?style=for-the-badge&logo=Checkstyle&logoColor=white" alt="Checkstyle badge">
  <img src="https://img.shields.io/badge/-Java-%23ED8B00?style=for-the-badge&logo=java&logoColor=white" alt ="Java badge">
  <img src = "https://img.shields.io/badge/-ANTLR-%237231d6?style=for-the-badge&logo=ANTLR&logoColor=white" alt = "ANTLR badge">
</div>

---
## Tools
- Language used is [Java](https://www.java.com/en/)
- Project is built using [maven](https://maven.apache.org/)  
- CI pipeline using [Github Actions](https://github.com/features/actions)
- Tests are written in [Junit5](https://junit.org/junit5/)
- Style is preserved using [checkStyle](https://checkstyle.sourceforge.io/)
- SQL is parsed using [ANTLR](https://www.antlr.org/)

---
## How to run tests and checks:
* Make sure to have [Apache Maven](https://maven.apache.org/) installed on your pc.
* To run checkStyle checks run the following command : `mvn checkstyle:check`
* To run Junit5 tests run the following command : `mvn test`  

---

## Code examples

### Normal Selection
```java
SQLTerm[] sqlTerms = new SQLTerm[2];
sqlTerms[0] = new SQLTerm("Students", "gpa", "=", 4.0);
sqlTerms[1] = new SQLTerm("Students", "id", ">", 100);
String[] strArrOperator = new String[] { "AND" };
engine.selectFromTable(sqlTerms, strArrOperator);
```
### Selection Using SQL
```java
StringBuffer command = new StringBuffer("SELECT * FROM Students WHERE gpa = 4.0 AND id > 100");
engine.parseSQL(command);
```
---

### Normal Insertion
```java
Hashtable<String, Object> htblColNameValue = new Hashtable<>();
htblColNameValue.put("id", 1);
htblColNameValue.put("name", "student1");
htblColNameValue.put("gpa", 3.3);
engine.insertIntoTable("Students", htblColNameValue);
```
### Insertion Using SQL
```java
StringBuffer command = new StringBuffer("INSERT INTO Students(id, gpa, name) VALUES(1, 3.3, 'student1')");
		engine.parseSQL(command);
```
---

### Normal Deletion
```java
Hashtable<String, Object> htblColNameValue = new Hashtable<>();
htblColNameValue.put("gpa", 3.3);
engine.DeleteFromTable("Students", htblColNameValue);
```
### Deletion Using SQL
```java
StringBuffer command = new StringBuffer("DELETE FROM  Students WHERE gpa = 3.3");
		engine.parseSQL(command);
```
---
## Project Structure
<details>
<summary>Expand</summary>

  ```mathematica
 - project-name/
  |- src/
     |- main/
        |- java/
           |- app/
              |- Action.java
              |- DBApp.java
              |- IDatabase.java
           |- constants/
              |- Constants.java
           |- datamanipulation/
              |- CsvReader.java
              |- CsvWriter.java
           |- exceptions/
              |- DBAppException.java
           |- sql/
              |- SQLTerm.java
              |- antlrfiles/
                 |- SQLiteLexer.java
                 |- SQLiteParser.java
                 |- SQLiteParserBaseListener.java
                 |- SQLiteParserBaseVisitor.java
                 |- SQLiteParserListener.java
                 |- SQLiteParserVisitor.java
                 |- SQLiteLexer.interp
                 |- SQLiteLexer.tokens
                 |- SQLiteParser.interp
                 |- SQLiteParser.tokens
              |- parser/
                 |- MiniDBListener.java
                 |- SQLParser.java
           |- storage/
              |- Cell.java
              |- Table.java
              |- Page.java
              |- Tuple.java
              |- TupleBuilder.java
              |- TupleDirector.java
              |- ITupleBuilder.java
              |- ITupleDirector.java
              |- index/
                 |- DBAppNull.java
                 |- Item.java
                 |- Vector3.java
                 |- OctreeIndex.java
                 |- OctreeNode.java
                 |- OctreeBounds.java
           |- util/
              |- Compare.java
              |- PagePrinter.java
              |- TypeParser.java
              |- filecontroller/
                 |- ConfigReader.java
                 |- FileCreator.java
                 |- FileDeleter.java
                 |- FileType.java
                 |- Serializer.java
              |- search/
                 |- PageSearch.java
                 |- TupleSearch.java
                 |- Selector.java
              |- validation/
                 |- Validator.java
     |- test/
        |- java/
           |- app/
              |- DBAppTest.java

  ```
</details>

---

## Run Locally

1- Clone the project

```bash
  git clone https://github.com/YehiaFarghaly/Database-Engine.git
```

2- Go to the project directory


3- Build the project using Maven
```bash
  mvn clean
```

4- Run Javafx project using Maven
```bash
  mvn javafx:run
```

### Notes

- There is a ready table called student with the following columns (ID: int, GPA: Double, Name: String)

---

## Screenshots

<details>
<summary>Selection Example</summary>  
	
![Screenshot (130)](https://github.com/YehiaFarghaly/Database-Engine/assets/87043730/f11989f1-9802-417e-b72e-d9d46a5cba30)
</details>  

<details>
<summary>Insertion Example</summary>  
	
![Screenshot (131)](https://github.com/YehiaFarghaly/Database-Engine/assets/87043730/22f540dc-7459-4cd9-abae-2fea1e8042f9)
</details>
	

<details>
<summary>Deletion Example</summary>  	
	
![Screenshot (132)](https://github.com/YehiaFarghaly/Database-Engine/assets/87043730/8e0f36a0-60af-4b21-978b-7eebc5cc725f)
</details>

##  License
[![MIT License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)



## Authors
- [Yehia Mohamed](https://github.com/YehiaFarghaly)
- [Malek Mohamed](https://github.com/malekelkssas)
- [Mohamed Khaled](https://github.com/Mohamed-Khaled308)
- [Abdelrahman Elmeky](https://github.com/Aelmeky)
- [Abdulrahman Fahmy](https://github.com/abdulrhman500)

