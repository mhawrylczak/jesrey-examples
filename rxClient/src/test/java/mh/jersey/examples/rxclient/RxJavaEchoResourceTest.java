package mh.jersey.examples.rxclient;


import org.glassfish.jersey.client.rx.RxWebTarget;
import org.glassfish.jersey.client.rx.rxjava.RxObservable;
import org.glassfish.jersey.client.rx.rxjava.RxObservableInvoker;
import org.junit.Test;
import rx.Observable;

import static org.junit.Assert.assertEquals;

/**
 * jersey-rx-client-rxjava
 */
public class RxJavaEchoResourceTest extends RxClientEchoTest {

    @Test
    public void testEcho() throws Exception {
        final String message = "Hello World!";

        RxWebTarget<RxObservableInvoker> webTarget = RxObservable.from(target("echo"));

        Observable<String> response = webTarget.path(message).request().rx().get(String.class);

        assertEquals(message, response.toBlocking().first());
    }
}