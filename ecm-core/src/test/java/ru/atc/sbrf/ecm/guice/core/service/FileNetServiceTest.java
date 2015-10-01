package ru.atc.sbrf.ecm.guice.core.service;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import ru.atc.sbrf.ecm.guice.core.model.FnDocument;
import ru.atc.sbrf.ecm.guice.core.module.CoreModule;
import ru.atc.sbrf.ecm.guice.core.service.impl.FileNetTestServiceImpl;

import static org.junit.Assert.*;

/**
 * Created by ashamsiev on 25.09.2015
 */
public class FileNetServiceTest {

    public static final String DOCUMENT_NAME = "First created document";

    private FileNetTestService fileNetTestService;

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new CoreModule());
        fileNetTestService = injector.getInstance(FileNetTestService.class);
    }

    @Test
    public void testDocCreation() throws Exception {

        FileNetTestService fnService = fileNetTestService;
        String docID = fnService.createAndFileDocument(DOCUMENT_NAME);

        FnDocument document = fnService.getDocument(docID);

        assertEquals("Document wasn't properly created for the given name.", DOCUMENT_NAME, document.getName());
    }
}