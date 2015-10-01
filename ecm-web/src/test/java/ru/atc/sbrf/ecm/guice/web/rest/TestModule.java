package ru.atc.sbrf.ecm.guice.web.rest;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.mockito.Mockito;
import ru.atc.sbrf.ecm.guice.core.service.SomeService;

import static org.mockito.Mockito.*;

/**
 * Created by ashamsiev on 01.10.2015
 */
public class TestModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    SomeService provideSomeService() {
        SomeService spyService = spy(SomeService.class);
        doReturn("testResponse").when(spyService).getStuff();
        return spyService;
    }
}
