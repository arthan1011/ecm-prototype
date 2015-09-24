package ru.atc.sbrf.ecm.guice.web.module;

import com.google.inject.AbstractModule;
import ru.atc.sbrf.ecm.guice.web.service.SomeService;
import ru.atc.sbrf.ecm.guice.web.service.impl.SomeServiceImpl;

/**
 * Created by ashamsiev on 24.09.2015
 */
public class WebModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SomeService.class).to(SomeServiceImpl.class);
    }
}
