# Super Market App

Super Market App REST-API application to administer inventary of super market.
Developed with Spring Boot (JAVA). (*In development*)


*CRUD REST-API*

### Table of contents 📃

- [Super Market App App](#super-market-app)
  - [Table of contents 📃](#table-of-contents)
  - [Starting 🚀](#starting-)
    - [Pre-requirements 📋](#pre-requirements)
    - [Installation 🔧](#installation)
    - [DataBase-Management-System](#DBMS)
  - [Built with 🛠️](#built-with)


## Starting 🚀
  
### Pre-requirements 📋

* [Git](https://git-scm.com/)

*DEVELOPMENT ENVIRONMENT*
* [APACHE-NEATBEANS](https://netbeans.apache.org/download/index.html) - recommended version +13
    * [PLUGIN](https://plugins.netbeans.apache.org/catalogue/?id=4) To work in spring boot 📌
* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/)
* [Visual Studio Code](https://code.visualstudio.com/download)
    * [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) Obligatory 📌
    * [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack) Obligatory 📌
* API PLATFORMS
    * [POSTMAN](https://www.postman.com/)
    * [TUNDER-CLIENT](https://www.thunderclient.com/) - VS Code extension

### Installation 🔧

Local installation:

```bash
$ git clone https://github.com/JefferGonzalez/super_market.git

# Change directory to the project path
$ cd super_market
```

### DBMS

In your DataBase Management System: 

Copy and executed the script file of folder (Url 'app/database/script.sql')

*application properties file setup*
```bash
In src/main/resources/application.properties file
update with you database credentials
```

## Built with 🛠️

* [JAVA](https://www.java.com/es/)) - Programming Languaje
    * [Spring Boot](https://spring.io/projects/spring-boot/) - Framework
* [MYSQL](https://www.mysql.com) - Database
    * [WORKBENCH](https://www.mysql.com/products/workbench/) - Visual Tool
