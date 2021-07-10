package com.cuong.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Value("${url.file.upload}")
    private String resourceFile;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String urlUpload = "";
        try {
            urlUpload = new ClassPathResource(resourceFile).getURL().getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        registry
                .addResourceHandler("/resources/upload-dir/**")
                .addResourceLocations(urlUpload);
    }
}