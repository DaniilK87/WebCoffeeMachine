package com.example.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    public static final String COFFEE_TAG = "Coffee info";
    public static final String COFFEE_BEANS_TAG = "Coffee Beans info";
    public static final String WATER_TAG = "Water info";
    public static final String MILK_TAG = "Milk info";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(COFFEE_TAG, "REST API с описанием функционала кофемашины"),
                        new Tag(COFFEE_BEANS_TAG,"REST API с описанием ёмкости для кофейных зёрен"),
                        new Tag(WATER_TAG,"REST API с описанием ёмкости для воды"),
                        new Tag(MILK_TAG,"REST API с описанием ёмкости для молока")
                )
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Программа по управлению кофемашины через браузер")
                .description("\"REST API управления кофемашины через браузер\"")
                .version("1.0.0")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
