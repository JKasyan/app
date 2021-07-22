package com.example.entry.http;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class OuterService {

    private final RestTemplate rt;
    private final String url;

    public OuterService(@NonNull final RestTemplate rt, final String url) {
        this.rt = rt;
        this.url = url;
    }

    public Optional<Integer> getRating(final long userId) {
        return Optional.ofNullable(rt.getForEntity(url, Integer.class, userId).getBody());
    }
}
