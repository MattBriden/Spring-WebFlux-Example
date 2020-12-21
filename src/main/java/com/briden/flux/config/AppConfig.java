package com.briden.flux.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.briden.flux.repository")
@EntityScan(basePackages={"com.briden.flux.entity"})
public class AppConfig {
}
