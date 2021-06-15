# This is just learning project 
This project is just my demo and lerning project of spring security and swagger with multiple profile


# Getting Started

If Dev profile is selected in application.properties then it will use Dev profile properties for further configuration of spring boot application.

For Dev profile, 
	Application is running on **9090** port with spring boot in-built tomcat server.
	Application will use db.changelog-dev.yaml file with liquibase to add or update database tables.

If Prod profile is selected in application.properties then it will use Prod profile properties for further configuration of spring boot application.

For Prod profile, 
	Application is running on **9091** port with spring boot in-built tomcat server.
	Application will use db.changelog-prod.yaml file with liquibase to add or update database tables.

##For swagger-ui : http://localhost:9091/swagger-ui.html
Swagger UI is only enabled for only dev profile. It will show not found page for other profile.