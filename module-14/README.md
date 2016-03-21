# Jenkins Default Task 06 
### Install Jenkins
Jenkins gives a lot of opportunities that allow you install it.
I just downloaded the .msi file. And install Jenkins as service from this file.

### Install Sonar
I downloaded zip archive and unpack it. After thet update /conf/sonar.properties file.
```
sonar.jdbc.username=postgres
sonar.jdbc.password=samepassword
sonar.jdbc.url=jdbc:postgresql://localhost/sonarqube
```
```
sonar.web.host=localhost
sonar.web.port=9000
sonar.web.context=/sonar
```
> I created the "sonarqube" database beforehand in postgres.

### Install Git plugin 
Manage Jenkins > Manage Plugins > Avaliable
Install "Git plugin" 

### Install SonarQube Plugin
Manage Jenkins > Manage Plugins > Avaliable
Install SonarQube Plugin

### Configure Jenkins
Manage Jenkins > Configure System
Maven 
- Name = mvn
- MAVEN_HOME = path\to\maven
SonarQube
- Name = SonarQube
- Server URL = http://localhost:9000
- SonarQube account login = admin
- SonarQube account password = admin
SonarQube Runner
- Name sonar-runner
- SONAR_RUNNER_HOME path\to\sonar-runner

New Item > Freestyle project (Instanse name set as "module-14")

Source Code Management = Git
- Repository URL = https://github.com/spring-projects/spring-petclinic   (In my case I used a local path to the cloned repository)
Build Triggers
- Poll SCM = true (Is used to build was carried out after changes in the git repository.)
- Schedule = "H/15 * * * *" (the frequency of possible builds)

Add 2 build setp:
Execute Windows batch command
- Command = mvn install

Invoke Standalone SonarQube Analysis
- set au all as default 