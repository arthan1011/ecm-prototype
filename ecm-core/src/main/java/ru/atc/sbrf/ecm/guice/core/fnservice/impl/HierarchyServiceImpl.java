package ru.atc.sbrf.ecm.guice.core.fnservice.impl;

import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ReferentialContainmentRelationship;
import ru.atc.sbrf.ecm.guice.core.fnservice.HierarchyService;
import ru.atc.sbrf.ecm.guice.core.fnservice.RepositoryService;

import javax.inject.Inject;

/**
 * Created by ashamsiev on 01.10.2015
 */
public class HierarchyServiceImpl implements HierarchyService {

    private RepositoryService repositoryService;

    @Inject
    public HierarchyServiceImpl(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public ReferentialContainmentRelationship fileDocument(Document document, String path) {
        Folder folder = Factory.Folder.fetchInstance(repositoryService.getObjectStore(), path, null);
        return folder.file(document, AutoUniqueName.AUTO_UNIQUE, null, DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
    }
}
