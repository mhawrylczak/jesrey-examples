package mh.jersey.examples.rxclient;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

public abstract class RxClientEchoTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig().register(EchoResource.class);
    }
}
