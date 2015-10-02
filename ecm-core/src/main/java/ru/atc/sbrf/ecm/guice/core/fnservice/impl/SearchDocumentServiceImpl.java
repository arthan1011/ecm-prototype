package ru.atc.sbrf.ecm.guice.core.fnservice.impl;

import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.collection.PageIterator;
import com.filenet.api.core.Document;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import ru.atc.sbrf.ecm.guice.core.fnservice.RepositoryService;
import ru.atc.sbrf.ecm.guice.core.fnservice.SearchDocumentService;

import javax.inject.Inject;

/**
 * Created by ashamsiev on 02.10.2015
 */
public class SearchDocumentServiceImpl implements SearchDocumentService {

    private RepositoryService repositoryService;

    @Inject
    public SearchDocumentServiceImpl(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void printDocumentTitles() {
        SearchSQL searchSQL = new SearchSQL("select [DocumentTitle], [ID] from document");

        SearchScope scope = new SearchScope(repositoryService.getObjectStore());

        IndependentObjectSet set = scope.fetchObjects(searchSQL, 10, null, true);

        PageIterator pageIterator = set.pageIterator();

        while (pageIterator.nextPage()) {
            System.out.println("** Documents in page: **");
            for (Object obj : pageIterator.getCurrentPage()) {
                Document document = (Document)obj;
                System.out.println("title: " + document.getProperties().getStringValue("DocumentTitle") + ", ID: " + document.get_Id().toString());
            }
            System.out.println();
        }
    }
}
