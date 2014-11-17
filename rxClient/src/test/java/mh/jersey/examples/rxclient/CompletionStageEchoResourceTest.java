package mh.jersey.examples.rxclient;


import org.glassfish.jersey.client.rx.RxWebTarget;
import org.glassfish.jersey.client.rx.java8.RxCompletionStage;
import org.glassfish.jersey.client.rx.java8.RxCompletionStageInvoker;
import org.junit.Test;

import java.util.concurrent.CompletionStage;

import static org.junit.Assert.assertEquals;

/**
 * jersey-rx-client-java8
 */
public class CompletionStageEchoResourceTest extends RxClientEchoTest {

    @Test
    public void testEcho() throws Exception {
        final String message = "Hello World!";

        RxWebTarget<RxCompletionStageInvoker> webTarget = RxCompletionStage.from(target("echo"));

        CompletionStage<String> response = webTarget.path(message).request().rx().get(String.class);

        assertEquals(message, response.toCompletableFuture().get());

    }
}