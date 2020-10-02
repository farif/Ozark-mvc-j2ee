A vulnerable application developed that demonstrates two attacks:

[1.] Reflect XSS
[2.] Command Injection

Build:
Use the command to build the application

mvn clean install

Deploy:
Using the command to deploy the application in Glassfish 5.0.

asadmin deploy target/ozark-safe-app.war


Browse:
Open the URL in Firefox:
- http://localhost:8080/ozark-safe-app/


Dependencies:
- Maven
- GlassFish 5.0 
- mail/mailx (a simple command-line-mode mail user agent that is included by default in BSD)
