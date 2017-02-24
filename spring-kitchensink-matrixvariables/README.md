spring-kitchensink-matrixvariables: Kitchensink MatrixVariables Using Spring 4.x
========================================================================================
Author: Marius Bogoevici, Tejas Mehta, Joshua Wilson  
Level: Intermediate  
Technologies: JSP, JPA, JSON, Spring, JUnit  
Summary: The `spring-kitchensink-matrixvariables` quickstart showcases Spring 4.x's support for **Matrix Variables** in URLs that was introduced in Spring 3.2.  
Target Product: ${product.name}  
Source: <${github.repo.url}>  

What is it?
-----------

This is your project! It is a sample, deployable Maven 3 project to help you get your foot in the door developing with 
Java EE 7 and Spring in ${product.name.full} ${product.version} or later.

This project is setup to allow you to create a compliant Java EE 7 application using JSP, JPA and Spring 4.x. It 
includes a persistence unit and some sample persistence and transaction code to introduce you to database access in enterprise Java:

* This module showcases Spring 4.x's support for **Matrix Variables** in urls introduced in Spring 3.2.

* In `jboss-as-spring-mvc-context.xml` `<context:component-scan base-package="org.jboss.as.quickstarts.kitchensink.spring.matrixvariables.controller"/>` 
and `<mvc:annotation-driven/>` are used to register both the non-rest and rest controllers.  This is how it works normally, 
however if we want to use `@MatrixVariable` we must set the `removeSemicolonContent` property of `RequestMappingHandlerMapping` to `false`. 
This has been done by commenting out `<mvc:annotation-driven/>` and using `<bean class='org.jboss.as.quickstarts.kitchensink.spring.matrixvariables.config.WebConfig'/>`.
Then in the WebConfig class we set the `removeSemicolonContent` property to `false`.

* The controllers map the respective urls to methods using `@RequestMapping(url)`.

* To return JSON, the rest controller uses `@ResponseBody`.

* The datasource and entitymanager are retrieved via JNDI.

* An additional form is added in `index.jsp` which allows the user to filter the member list. The form is submitted in 
the url form: `/filter;n=Name;e=Email`.

* Using `@MatrixVariable` the controller method captures the values and feeds them to the memberDao.


System Requirements
-------------------

The application this project produces is designed to be run on ${product.name.full} ${product.version} or later. 

All you need to build this project is ${build.requirements}. See [Configure Maven for ${product.name} ${product.version}](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN_JBOSS_EAP7.md#configure-maven-to-build-and-deploy-the-quickstarts) to make sure you are configured correctly for testing the quickstarts.


Start the ${product.name} Server
-------------------------

1. Open a command line and navigate to the root of the ${product.name} directory.
2. The following shows the command line to start the server:

        For Linux:   ${jboss.home.name}/bin/standalone.sh
        For Windows: ${jboss.home.name}\bin\standalone.bat

 
Build and Deploy the Quickstart
-------------------------

1. Make sure you have started the ${product.name} server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean install wildfly:deploy

4. This will deploy `target/${project.artifactId}.war` to the running instance of the server.


Access the application
----------------------

The application will be running at the following URL: <http://localhost:8080/${project.artifactId}/>.


Undeploy the Archive
--------------------

1. Make sure you have started the ${product.name} server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn wildfly:undeploy


Run the Arquillian Functional Tests
-----------------------------------

This quickstart provides Arquillian functional tests as well. They are located in the functional-tests/ subdirectory under 
the root directory of this quickstart. Functional tests verify that your application behaves correctly from the user's point 
of view. The tests open a browser instance, simulate clicking around the page as a normal user would do, and then close the browser instance.

To run these tests, you must build the main project as described above.

1. Open a command line and navigate to the root directory of this quickstart.
2. Build the quickstart WAR using the following command:

        mvn clean package

3. Navigate to the functional-tests/ directory in this quickstart.
4. If you have a running instance of the ${product.name} server, as described above, run the remote tests by typing the following command:

        mvn clean verify -Parq-wildfly-remote

5. If you prefer to run the functional tests using managed instance of the ${product.name} server, meaning the tests will start the 
server for you, type the following command:

        mvn clean verify -Parq-wildfly-managed


Run the Quickstart in Red Hat JBoss Developer Studio or Eclipse
-------------------------------------

You can also start the server and deploy the quickstarts or run the Arquillian tests from Eclipse using JBoss tools. For general information about how to import a quickstart, add a ${product.name} server, and build and deploy a quickstart, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](${use.eclipse.url}). 


Debug the Application
---------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following 
commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc
