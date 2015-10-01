package ru.atc.sbrf.ecm.guice.core.fnservice;

import com.filenet.api.core.Document;
import com.filenet.api.core.ReferentialContainmentRelationship;
import ru.atc.sbrf.ecm.guice.core.service.impl.FileNetTestServiceImpl;

/**
 * Created by ashamsiev on 01.10.2015
 */
public interface HierarchyService {
    ReferentialContainmentRelationship fileDocument(Document document, String path);
}
