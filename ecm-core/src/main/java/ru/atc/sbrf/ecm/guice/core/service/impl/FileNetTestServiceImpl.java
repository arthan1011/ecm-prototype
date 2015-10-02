package ru.atc.sbrf.ecm.guice.core.service.impl;

import com.filenet.api.constants.*;
import com.filenet.api.core.*;
import com.filenet.api.property.FilterElement;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.util.Id;
import ru.atc.sbrf.ecm.guice.core.fnservice.SearchDocumentService;
import ru.atc.sbrf.ecm.guice.core.model.FnDocument;
import ru.atc.sbrf.ecm.guice.core.service.FileNetTestService;
import ru.atc.sbrf.ecm.guice.core.fnservice.HierarchyService;
import ru.atc.sbrf.ecm.guice.core.util.FnUtils;
import ru.atc.sbrf.ecm.guice.core.fnservice.RepositoryService;

import javax.inject.Inject;

/**
 * Created by ashamsiev on 25.09.2015
 */
public class FileNetTestServiceImpl implements FileNetTestService {

    private HierarchyService hierarchyService;
    private RepositoryService repositoryService;
    private SearchDocumentService searchDocumentService;

    @Inject
    public FileNetTestServiceImpl(HierarchyService hierarchyService,
                                  RepositoryService repositoryService,
                                  SearchDocumentService searchDocumentService) {
        this.hierarchyService = hierarchyService;
        this.repositoryService = repositoryService;
        this.searchDocumentService = searchDocumentService;
    }

    public static final PropertyFilter ID_FILTER = new PropertyFilter();
    static {
        ID_FILTER.addIncludeProperty(
                new FilterElement(null, null, null, PropertyNames.ID, null)
        );
    }

    public void printNames() {
        searchDocumentService.printDocumentTitles();
    }

    public String createAndFileDocument(String documentName) {

        Document document = createDocument(documentName);
        ReferentialContainmentRelationship rcr = hierarchyService.fileDocument(document, "/test-folder");

        saveChanges(document, rcr);

        FnUtils.printProperties(document);

        return document.get_Id().toString();
    }

    /**
     * Думаю round-trip'ы с FileNet должные быть только в таких методах, которые синхронизируют локальные и нелокальные
     * данные
     * @param document first parameter
     * @param rcr second parameter
     */
    public void saveChanges(IndependentlyPersistableObject document, IndependentlyPersistableObject rcr) {
        UpdatingBatch updatingBatch = UpdatingBatch.createUpdatingBatchInstance(repositoryService.getObjectStore().get_Domain(), RefreshMode.REFRESH);
        updatingBatch.add(document, ID_FILTER);
        updatingBatch.add(rcr, null);
        updatingBatch.updateBatch();
    }

    private Document createDocument(String documentName) {
        Document document = Factory.Document.createInstance(repositoryService.getObjectStore(), "Document");
        document.getProperties().putValue("DocumentTitle", documentName);
        document.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
        return document;
    }

    public FnDocument getDocument(String documentID) {
        return getDocument(documentID, true);
    }

    public FnDocument getDocument(String documentID, boolean removeDocument) {
        Document document = Factory.Document.fetchInstance(repositoryService.getObjectStore(), new Id(documentID), null);

        FnDocument fnDocument = new FnDocument();
        fnDocument.setName(document.getProperties().getStringValue("DocumentTitle"));

        if (removeDocument) {
            document.delete();
            document.save(RefreshMode.NO_REFRESH);
        }
        return fnDocument;
    }

}
