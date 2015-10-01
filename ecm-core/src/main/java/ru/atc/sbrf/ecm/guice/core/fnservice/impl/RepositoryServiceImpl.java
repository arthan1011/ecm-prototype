package ru.atc.sbrf.ecm.guice.core.fnservice.impl;

import com.filenet.api.collection.ObjectStoreSet;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.util.UserContext;
import ru.atc.sbrf.ecm.guice.core.fnservice.RepositoryService;

import javax.security.auth.Subject;
import java.util.Iterator;

/**
 * Created by ashamsiev on 01.10.2015
 */
public class RepositoryServiceImpl implements RepositoryService {

    public ObjectStore getObjectStore() {
        // connecting
        Connection connection = Factory.Connection.getConnection("http://192.168.15.237:9080/wsi/FNCEWS40MTOM");
        Subject subject = UserContext.createSubject(connection, "p8admin", "passw0rd", null);
        UserContext userContext = UserContext.get();
        userContext.pushSubject(subject);

        // retrieving objectStore
        Domain domain = Factory.Domain.fetchInstance(connection, "demo", null);
        ObjectStore currentStore = null;
        ObjectStoreSet objectStoresSet = domain.get_ObjectStores();
        Iterator osIterator = objectStoresSet.iterator();
        while (osIterator.hasNext()) {
            ObjectStore objectStore = (ObjectStore) osIterator.next();
            if (objectStore.get_Name().equalsIgnoreCase("OS")) {
                currentStore = objectStore;
                break;
            }
        }
        return currentStore;
    }
}
