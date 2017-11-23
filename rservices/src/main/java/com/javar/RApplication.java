package com.javar;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.javar.configuration.RApplicationConfiguration;

public class RApplication extends Application<RApplicationConfiguration> {

    @Override
    public void initialize(Bootstrap<RApplicationConfiguration> bootstrap) {
        bootstrap
            .getObjectMapper()
            .registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        bootstrap.addBundle(GuiceBundle
            .<RApplicationConfiguration>builder()
            .enableAutoConfig("com.javar")
            .searchCommands()
            .build());
    }

    @Override
    public void run(RApplicationConfiguration configuration, Environment environment) throws Exception {
        enableCors(environment);
    }

    public static void main(String[] args) {
        try {
            new RApplication().run(args);
        } catch (Exception e) {
            throw new RuntimeException("RApplication failed", e);
        }
    }

    private void enableCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
            environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "*");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
