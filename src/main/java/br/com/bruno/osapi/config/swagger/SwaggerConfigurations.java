package br.com.bruno.osapi.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bruno.osapi.modelo.Cliente;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket ordemServicoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.bruno.osapi"))
				.paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(Cliente.class);

	}	

}
