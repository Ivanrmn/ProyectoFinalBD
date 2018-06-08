package org.mvpigs.proyectoFinalBD.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	@Value(value = "${app.cors.allowed.origin}")
	private String allowedOrigin;

	@Value("${swagger.enabled}")
	private boolean swaggerEnabled;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedOrigins(allowedOrigin);
	}

	/**
	 * Enables Swagger /swagger-ui.html resource.
	 * 
	 * @param registry
	 *            ResourceHandlerRegistry.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		if (swaggerEnabled) {

			registry.addResourceHandler("swagger-ui.html")
					.addResourceLocations("classpath:/META-INF/resources/");

			registry.addResourceHandler("/webjars/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/");
		}

	}
}
