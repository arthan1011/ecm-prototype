package ru.atc.sbrf.ecm.guice.core.util;

import com.filenet.api.core.EngineObject;
import com.filenet.api.property.Properties;

import java.util.Iterator;

/**
 * Created by ashamsiev on 01.10.2015
 */
public class FnUtils {
    public static void printProperties(EngineObject document) {
        Properties properties = document.getProperties();

        Iterator iterator = properties.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
