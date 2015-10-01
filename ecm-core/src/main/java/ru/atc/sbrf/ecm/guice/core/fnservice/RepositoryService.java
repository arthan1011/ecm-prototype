package ru.atc.sbrf.ecm.guice.core.fnservice;

import com.filenet.api.core.ObjectStore;

/**
 * Created by ashamsiev on 01.10.2015
 */
public interface RepositoryService {
    ObjectStore getObjectStore();
}
