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

## Screenshots of the web pages

![a1](https://user-images.githubusercontent.com/66872471/85219766-31e0cf00-b3c4-11ea-8fd8-87882c22f09d.PNG)
![a2](https://user-images.githubusercontent.com/66872471/85219768-34432900-b3c4-11ea-8568-1733a4e3372f.PNG)
![a3](https://user-images.githubusercontent.com/66872471/85219770-34dbbf80-b3c4-11ea-9ad6-9b6f530d00d9.PNG)
![a4](https://user-images.githubusercontent.com/66872471/85219771-35745600-b3c4-11ea-86f5-2306499559ef.png)
![a5](https://user-images.githubusercontent.com/66872471/85219776-3dcc9100-b3c4-11ea-9983-bc902386040c.PNG)
![a6](https://user-images.githubusercontent.com/66872471/85219779-41f8ae80-b3c4-11ea-81cb-7276c03492e0.png)
![a7](https://user-images.githubusercontent.com/66872471/85219787-4d4bda00-b3c4-11ea-8cc4-4ddf5482c576.png)
![a8](https://user-images.githubusercontent.com/66872471/85219795-53da5180-b3c4-11ea-8ebf-9b7ab5029540.png)
![a9](https://user-images.githubusercontent.com/66872471/85219797-576dd880-b3c4-11ea-8581-9c4dfba0e0b4.PNG)
![a10](https://user-images.githubusercontent.com/66872471/85219798-59379c00-b3c4-11ea-83a3-40938eadf47a.png)
![a11](https://user-images.githubusercontent.com/66872471/85219799-5a68c900-b3c4-11ea-9bc8-1c8190ff168b.PNG)
![a12](https://user-images.githubusercontent.com/66872471/85219800-5c328c80-b3c4-11ea-8451-4bd8a78f6424.png)
![a13](https://user-images.githubusercontent.com/66872471/85219802-5d63b980-b3c4-11ea-8708-ffb65889617b.png)
![b1](https://user-images.githubusercontent.com/66872471/85219803-5e94e680-b3c4-11ea-8731-8d16daecd329.png)
![b2](https://user-images.githubusercontent.com/66872471/85219806-60f74080-b3c4-11ea-9a9f-b3f81d7f410a.png)
![b3](https://user-images.githubusercontent.com/66872471/85219807-63599a80-b3c4-11ea-8808-76302a286de5.png)
![b4](https://user-images.githubusercontent.com/66872471/85219810-66548b00-b3c4-11ea-89c6-91b04dfec6de.png)
![b5](https://user-images.githubusercontent.com/66872471/85219816-6a80a880-b3c4-11ea-91a0-c568b317873a.png)
![c1](https://user-images.githubusercontent.com/66872471/85219818-6ce30280-b3c4-11ea-88ea-7f8ef70d24dd.png)
![c2](https://user-images.githubusercontent.com/66872471/85219820-6eacc600-b3c4-11ea-95ad-51f10ddf9f82.png)

