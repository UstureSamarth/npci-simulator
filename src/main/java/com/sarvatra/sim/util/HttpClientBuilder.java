package com.sarvatra.sim.util;

import io.netty.buffer.Unpooled;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jpos.util.Log;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HttpClientBuilder {

    static final Log logger = Log.getLog("Q2", "http-client");

    private static final HttpClient HTTP_CLIENT = HttpClient.create()
            .compress(true)
            .keepAlive(true)
            .responseTimeout(Duration.ofSeconds(10));

    public static void sendAsync(String url, String respXml, int delay) {
        Mono.delay(Duration.ofSeconds(delay))
                .flatMap(t ->
                        HTTP_CLIENT.headers(h -> h.set("Content-Type", "application/xml")).post().uri(url)
                                .send(Mono.just(Unpooled.wrappedBuffer(respXml.getBytes(StandardCharsets.UTF_8))))
                                .responseSingle((res, body) ->
                                        body.asString().map(content -> {
                                            if (res.status().code() >= 400) {
                                                throw new RuntimeException("HTTP Error: " + res.status());
                                            }
                                            return content;
                                        })
                                )
                ).subscribe(
                        r -> logger.info("Ack -> " + r),
                        e -> logger.error("Error -> " + e.getMessage())
                );
    }

}
