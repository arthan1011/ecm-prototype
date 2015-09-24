package ru.atc.sbrf.ecm.guice.core.service.impl;

import ru.atc.sbrf.ecm.guice.core.service.SomeService;

/**
 * Created by ashamsiev on 24.09.2015
 */
public class SomeServiceImpl implements SomeService {
    public String getStuff() {
        return "Meaningful text from another module";
    }
}
