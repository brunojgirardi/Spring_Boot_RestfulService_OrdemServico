package br.com.bruno.osapi.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Value("${osapi.swagger.path}")
	private String swaggerPath;
	
	@Bean
	public Docket ordemServicoApi() {
		return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
				.groupName("All")
				.apiInfo(ordemServicoInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.bruno.osapi"))
				.paths(PathSelectors.any())
                .build();   
	}

	private ApiInfo ordemServicoInfo() {
		return new ApiInfoBuilder()
				.title("Ordem de Servico API")
				.description("Sistema de Ordem de Serviço")
				.termsOfServiceUrl("http://localhost:8080")
				.license("")
				.licenseUrl("http//localhost:8080")
				.version("1.0")
				.build();
	}

}