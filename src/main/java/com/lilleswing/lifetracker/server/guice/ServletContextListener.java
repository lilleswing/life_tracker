package com.lilleswing.lifetracker.server.guice;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.lilleswing.lifetracker.server.guice.filters.BasicAuthFilter;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.lilleswing.lifetracker.server.guice.filters.MyExceptionMapper;
import com.lilleswing.lifetracker.server.guice.filters.UnitOfWorkFilter;

public class ServletContextListener extends GuiceServletContextListener {
    private static final String SERVICES_PACKAGE = "com.lilleswing.lifetracker.server.server";

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {

            @Override
            protected void configureServlets() {
                bind(GuiceContainer.class);

                final PackagesResourceConfig resourceConfig = new PackagesResourceConfig(SERVICES_PACKAGE);
                for (final Class<?> resource : resourceConfig.getClasses()) {
                    bind(resource);
                }

                bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);

                bind(MyExceptionMapper.class);
                filter("/api/*").through(UnitOfWorkFilter.class);
                filter("/api/*").through(BasicAuthFilter.class);
                serve("/api/*").with(GuiceContainer.class);
            }
        }, new ServerModule());
    }
}
