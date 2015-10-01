package ru.atc.sbrf.ecm.guice.core.module;

import com.google.inject.AbstractModule;
import ru.atc.sbrf.ecm.guice.core.fnservice.HierarchyService;
import ru.atc.sbrf.ecm.guice.core.fnservice.RepositoryService;
import ru.atc.sbrf.ecm.guice.core.fnservice.impl.HierarchyServiceImpl;
import ru.atc.sbrf.ecm.guice.core.fnservice.impl.RepositoryServiceImpl;
import ru.atc.sbrf.ecm.guice.core.service.FileNetTestService;
import ru.atc.sbrf.ecm.guice.core.service.impl.FileNetTestServiceImpl;

/**
 * Created by ashamsiev on 01.10.2015
 */
public class CoreModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RepositoryService.class).to(RepositoryServiceImpl.class);
        bind(HierarchyService.class).to(HierarchyServiceImpl.class);
        bind(FileNetTestService.class).to(FileNetTestServiceImpl.class);
    }
}
