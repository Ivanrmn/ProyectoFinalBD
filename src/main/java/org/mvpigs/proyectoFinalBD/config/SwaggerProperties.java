package org.mvpigs.proyectoFinalBD.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Swagger Configuration Properties (see application.properties). Used by SpringApiSwaggerConfig.
 */
@Component
@ConfigurationProperties(prefix = "swagger")
class SwaggerProperties {

	private String basePackage;
	private String pathsRegex;
	private String title;
	private String description;
	private String license;
	private String version;

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getPathsRegex() {
		return pathsRegex;
	}

	public void setPathsRegex(String pathsRegex) {
		this.pathsRegex = pathsRegex;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
