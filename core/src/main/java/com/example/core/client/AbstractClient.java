package com.example.core.client;

import com.example.core.consul.Service;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {

    private final RestTemplate restTemplate;
    private final String url;
    private final static String URL_TEMPLATE = "https://%s/";

    public AbstractClient(final RestTemplate restTemplate, final Service service) {
        this.restTemplate = restTemplate;
        this.url = String.format(URL_TEMPLATE, service);
    }

    protected <T> T call(final String uri, final Class<T> respClass, Object req) {
        return restTemplate.getForObject(url + uri, respClass, req);
    }

    protected <T> T call(final String uri, final Class<T> respClass) {
        return restTemplate.getForObject(url + uri, respClass);
    }
}
