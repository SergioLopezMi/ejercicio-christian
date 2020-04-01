package com.sergio.coches.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.sergio.coches.repository", "com.sergio.coches.service" })
public class JavaConfig {

}
