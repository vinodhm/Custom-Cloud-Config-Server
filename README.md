# Custom-Cloud-Config-Server

Description:
       
 - Setting up Config Server Using JDBCEnvironmentRepository which uses MySql as Back end  
 
 - It will be deployed as a spring-boot app and expose configurations     
     
 - Will be able to access properties using below without implementing security
 
     key value pair : http://localhost:8888/{application}-{profile}.properties     
     example : http://localhost:8888/pricing-default.properties      
     JSON : http://localhost:8888/{application}/{profile}/{label}   
     example : http://localhost:8888/pricing-service/qa/qa
 - to see all the properties:  
     http://localhost:8888/properties
 
Assumptions: 
- Will be able to use Relational Database for storing the configurations

Health Check:
- http://localhost:8888/actuator/health

Maven Command to run: 
- mvn spring-boot:run -Drun.jvmArguments="-Xmx1024m"  

