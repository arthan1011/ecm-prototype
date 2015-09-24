package ru.atc.sbrf.ecm.guice.web.service.impl;

import ru.atc.sbrf.ecm.guice.web.service.SomeService;

/**
 * Created by ashamsiev on 24.09.2015
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public String getStuff() {
        return "Meaningful text";
    }
}
