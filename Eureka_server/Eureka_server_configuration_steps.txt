Adding Eureka Server:

1) Create a spring boot project with Eureka Server dependency:
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
2) Add @EnableEurekaServer annotation to main class:
	@SpringBootApplication
	@EnableEurekaServer
	public class TempEurekaServerApplication {
		public static void main(String[] args) {
			SpringApplication.run(TempEurekaServerApplication.class, args);
		}
	}
	
3) Add below properties into application.yml so that Eureka Server Application won't register itself into Eureka Server Registry.
	server:
	  port: 8761
	  
	eureka:
	  client:
	    register-with-eureka: false
	    fetch-registry: false

4) Start Eureka Server using http://localhost:8761

5) In order to register microservices into Eureka Server, add below dependency in microservices spring boot app:
<dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
      <version>3.0.3</version>
</dependency>

6) Add @EnableEurekaClient annotation to microservice main class.
	@SpringBootApplication
	@EnableEurekaClient
	public class OlxLoginApplication {
	}
	
7) Add below configuration in microservice application.yml:
	spring.application.name=login-service

8) Now you can start microservice & make sure it is registered in Eureka Server on specified port using localhost:8761
	
9) If you wish Eureka to assign random port to microservice then add following properties in application.yml
	server.port=0
	eureka.instance.instance-id=${spring.application.name}:{random.uuid}
	