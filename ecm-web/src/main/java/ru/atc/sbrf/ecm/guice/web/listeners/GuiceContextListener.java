package ru.atc.sbrf.ecm.guice.web.listeners;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import ru.atc.sbrf.ecm.guice.web.module.WebModule;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashamsiev on 24.09.2015
 */
public class GuiceContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new JerseyServletModule() {
                    @Override
                    protected void configureServlets() {
                        ResourceConfig rc = new PackagesResourceConfig("ru.atc.sbrf.ecm.guice.web.rest");
                        for (Class<?> resource : rc.getClasses()) {
                            bind(resource);
                        }

                        bind(JacksonJsonProvider.class).in(Singleton.class);

                        serve("/services/*").with(GuiceContainer.class);
                    }
                },
                new WebModule()
        );
    }
}
