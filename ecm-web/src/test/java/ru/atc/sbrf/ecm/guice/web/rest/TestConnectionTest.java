package ru.atc.sbrf.ecm.guice.web.rest;


import com.google.inject.Guice;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.inmemory.GuiceInMemoryTestContainerFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.atc.sbrf.ecm.guice.web.listeners.GuiceContextListener;
import ru.atc.sbrf.ecm.guice.web.module.WebModule;

/**
 * Created by ashamsiev on 01.10.2015
 */

@Ignore
public class TestConnectionTest extends JerseyTest {

    public TestConnectionTest() throws TestContainerException {
        super(new GuiceInMemoryTestContainerFactory(Guice.createInjector(new TestModule())));
    }

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder("ru.atc.sbrf.ecm.guice.web.rest")
                .initParam("com.sun.jersey.api.json.POJOMappingFeature", "true")
                .contextListenerClass(GuiceContextListener.class)
                .build();
    }


    @Test
    public void testPost() throws Exception {
        WebResource webResource = resource();
        String message = webResource.path("test/inputjson")
                .header("Content-Type", "application/json")
                .post(String.class, "{\"userID\" : 32, \"objectStoreName\" : \"Deo\"}");
        System.out.println(message);

    }

    @Test
    public void testGet() throws Exception {
        String getResponse = resource()
                .path("test")
                .get(String.class);

        Assert.assertEquals("Incorrect get response", "<body><h1>Hello! Connection established.</h1><h3>testResponse</h3></body>", getResponse);
    }
}