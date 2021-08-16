package com.example.core.client;

import com.example.core.consul.Service;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {

    protected final Service service;
    private final RestTemplate rt;

    protected AbstractClient(final Service service, final RestTemplate rt) {
        this.service = service;
        this.rt = rt;
    }

    protected <T> T call(final String url, final Class<T> respClass) {
        return rt.getForObject(url, respClass);
    }
}
