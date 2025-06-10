package com.narendra.dtoandexception.config;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.catalina.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {
    @Bean
    public OpenAPI myconfig_product(){
        return new OpenAPI().info(new Info().title("Product Details").description("Handel by narendra"));
    }
}
