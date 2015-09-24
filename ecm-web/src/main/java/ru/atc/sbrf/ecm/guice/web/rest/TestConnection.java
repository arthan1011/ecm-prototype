package ru.atc.sbrf.ecm.guice.web.rest;


import com.google.inject.Inject;
import ru.atc.sbrf.ecm.guice.core.service.SomeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by ashamsiev on 24.09.2015
 */

@Path("test")
public class TestConnection {

    private SomeService someService;

    @Inject
    public TestConnection(SomeService someService) {
        this.someService = someService;
    }

    @GET
    @Produces("text/html")
    public String hello() {
        return "<body><h1>Hello! Connection established.</h1>" +
                "<h3>" + someService.getStuff() + "</h3>" +
                "</body>";
    }
}
