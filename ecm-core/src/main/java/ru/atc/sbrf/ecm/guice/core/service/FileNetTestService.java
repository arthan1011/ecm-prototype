package ru.atc.sbrf.ecm.guice.core.service;

import ru.atc.sbrf.ecm.guice.core.model.FnDocument;

/**
 * Created by ashamsiev on 25.09.2015
 */
public interface FileNetTestService {


    void printNames();

    /**
     *
     * @param documentName name of document to be created
     * @return id of created document
     */
    String createAndFileDocument(String documentName);

    FnDocument getDocument(String documentID);

    FnDocument getDocument(String documentID, boolean remove);
}
