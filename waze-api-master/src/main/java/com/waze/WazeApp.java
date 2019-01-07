package com.waze;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.waze.controller.WazeEndPoint;
import com.waze.service.WazeNotificationService;
import com.waze.service.WazeRouteService;
import io.dropwizard.Application;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.IOException;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableDiscoveryClient
public class WazeApp extends Application<WazeConfig> {

    public static void main(String[] args) throws Exception {

        System.setProperty("file.encoding", "UTF-8");
        SpringApplication.run(WazeApp.class, args);
    }

    @Override
    public String getName() {
        return "waze-app";
    }

    @Override
    public void initialize(Bootstrap<WazeConfig> bootstrap){}

    @Override
    public void run(WazeConfig conf,
                    Environment env) throws IOException {

        env.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        final WazeRouteService wazeRouteService = new WazeRouteService();
        final WazeNotificationService wazeNotificationService = new WazeNotificationService();
        final WazeEndPoint wazeEndPoint = new WazeEndPoint(wazeRouteService, wazeNotificationService);
        final WazeHealthCheck wazeHealthCheck = new WazeHealthCheck(wazeRouteService);

        env.healthChecks().register("waze", wazeHealthCheck);

        env.jersey().register(wazeEndPoint);
    }

}
