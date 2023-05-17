# Database-Engine
Database Engine that supports some operations like:
- Creating a table
- Inserting into a table
- Updating a table
- Deleting from a table
- Selecting from a table
- Creating an Index -using Octree-
- Writing SQL queries  
</br>

[![Java CI with Maven](https://github.com/YehiaFarghaly/Database-Engine/actions/workflows/maven.yml/badge.svg)](https://github.com/YehiaFarghaly/Database-Engine/actions/workflows/maven.yml)  
<div style="display: flex;">
  <img src="https://img.shields.io/badge/Apache-maven-%23C71A36?style=for-the-badge&logo=ApacheMaven" alt="Apache Maven badge">
  <img src="https://img.shields.io/badge/Github-Actions-%232088FF?style=for-the-badge&logo=GithubActions" alt="Github Actions badge">
  <img src="https://img.shields.io/badge/Junit5-tests-%2325A162?style=for-the-badge&logo=Junit5" alt="Junit 5 badge">
  <img src="https://img.shields.io/badge/Git--%23F05032?style=for-the-badge&logo=Git" alt="Git badge">
  <img src="https://img.shields.io/badge/-Github-%23181717?style=for-the-badge&logo=Github" alt="Github badge">
  <img src="https://img.shields.io/badge/-Dependabot-%23025E8C?style=for-the-badge&logo=Dependabot" alt="Dependabot badge">
</a>
  <a href="https://checkstyle.org/" target="_blank">
  <img src="https://img.shields.io/badge/Checkstyle-8.43-blue?style=for-the-badge&logo=checkstyle" alt="Checkstyle badge">
</a> 
</div>

---
## Tools
- Language used is [Java](https://www.java.com/en/)
- Project is built using [maven](https://maven.apache.org/)  
- CI pipelines using [Github Actions](https://github.com/features/actions)
- Tests are written in [Junit5](https://junit.org/junit5/)
- Style is preserved using [checkStyle](https://checkstyle.sourceforge.io/)
- SQL is parsed using [ANTLR](https://www.antlr.org/)
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
```
StringBuffer command = new StringBuffer("SELECT * FROM Students WHERE gpa = 4.0 AND id = 100");
engine.parseSQL(command);
```
## Running Application

## Authors

