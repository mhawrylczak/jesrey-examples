package mh.jersey.examples.rxclient;


import jersey.repackaged.jsr166e.CompletableFuture;
import org.glassfish.jersey.client.rx.RxWebTarget;
import org.glassfish.jersey.client.rx.java8.RxCompletionStage;
import org.glassfish.jersey.client.rx.java8.RxCompletionStageInvoker;
import org.glassfish.jersey.client.rx.jsr166e.RxCompletableFuture;
import org.glassfish.jersey.client.rx.jsr166e.RxCompletableFutureInvoker;
import org.junit.Test;

import java.util.concurrent.CompletionStage;

import static org.junit.Assert.assertEquals;

/**
 * jersey-rx-client-jsr166e
 */
public class CompletableFutureEchoResourceTest extends RxClientEchoTest {

    @Test
    public void testEcho() throws Exception {
        final String message = "Hello World!";

        RxWebTarget<RxCompletableFutureInvoker> webTarget = RxCompletableFuture.from(target("echo"));

        CompletableFuture<String> response = webTarget.path(message).request().rx().get(String.class);

        assertEquals(message, response.get());

    }
}