# Budget-Management-System

An application for every aspect of money

### Note :

- These programs are written in aspect of Tomcat Server and are exceuted in Tomcat Server.
- Steps for deploying Tomcat Server:
* PROJECTNAME
     * WEB-INF   > classes >> all .java files >> all .class files
     * WEB_INF   > lib >> ojdbc6.jar file >> servlet-api.jar file
     * WEB_INF   > web.xml
     * All the html files and images

*  **Create a WEB-INF folder**
*  **Create classes and lib folder within WEB-INF**
*  **Create a web.xml file within WEB-INF**
*  **classes contains all .class files and .java files**
*  **lib folder contains server and database files**
*  **Below WEB-INF, all HTML files and images are stored**
       
       
## HTML files

* The entry page is named with project.html and it contains description of project
* If you were a new user you have to click through **sign up** button.
* On clicking **sign** up button,register.html file is executed and details of the user are filled.If you are an already existing user.It will display mobile number or email already registered or else you move through **Lets get started page**.
* On clicking **Login button**,login.html is executed and details of the user are entered.If user is not registered it shows an error message that username or password is not valid.

## Servlet Programmming ( Java )

* Register Servlet is exceuted when you are successfully logged in.
* When you click on **Lets get Started** button,you will display a page with start date and end dates(add.java program executes).
* On clicking **submit** button (EntryPage.html file is executed ) The page appears to create new budget.We note down the necessary details regarding the salary,expenses of our budget and then we click on **submit**.
* We can now enter the particular details of every object with what price we have bought that object and then we click on **Done** button.
* When we click **show graph** button,it displays the graph of out transactions on the dates you have purchased.
* When we click **show transactions** button,it displays all the transactions sorted according to date wise.



