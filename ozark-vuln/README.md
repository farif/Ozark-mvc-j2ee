The secure application that demonstrates fend off attacks:
[1.] Reflect XSS
[2.] Command Injection

Build:
Use the command to build the application

mvn clean install

Deploy:
Using the command to deploy the application in Glassfish 5.0.

asadmin deploy target/ozark-vuln-app.war


Browse:
Open the URL in Firefox:
- http://localhost:8080/ozark-vuln-app/


Dependencies:
- Maven
- GlassFish 5.0 
- mail/mailx (a simple command-line-mode mail user agent that is included by default in BSD)
