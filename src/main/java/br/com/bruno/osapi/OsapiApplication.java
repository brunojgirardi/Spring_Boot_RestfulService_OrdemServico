package br.com.bruno.osapi;
//comentario projeto ana
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
