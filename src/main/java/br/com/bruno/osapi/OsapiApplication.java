<<<<<<< HEAD
package br.com.bruno.osapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class OsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsapiApplication.class, args);
	}

}
=======
package br.com.bruno.osapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class OsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsapiApplication.class, args);
	}

}
>>>>>>> 582d4c0d73dd8a2a3149de2ef90ed4dcb92d373c
