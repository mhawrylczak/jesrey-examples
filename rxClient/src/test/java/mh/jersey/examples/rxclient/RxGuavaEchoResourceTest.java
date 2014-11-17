package mh.jersey.examples.rxclient;


import com.google.common.util.concurrent.ListenableFuture;
import org.glassfish.jersey.client.rx.RxWebTarget;
import org.glassfish.jersey.client.rx.guava.RxListenableFuture;
import org.glassfish.jersey.client.rx.guava.RxListenableFutureInvoker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * jersey-rx-client-guava
 */
public class RxGuavaEchoResourceTest extends RxClientEchoTest {

    @Test
    public void testEcho() throws Exception {
        final String message = "Hello World!";

        RxWebTarget<RxListenableFutureInvoker> webTarget = RxListenableFuture.from(target("echo"));

        ListenableFuture<String> response = webTarget.path(message).request().rx().get(String.class);

        assertEquals(message, response.get());

    }
}