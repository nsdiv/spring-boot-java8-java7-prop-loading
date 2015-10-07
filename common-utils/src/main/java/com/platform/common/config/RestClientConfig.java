package com.platform.common.config;

import com.platform.common.rest.RestClientSettings;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.ProxySelector;

@Configuration
public class RestClientConfig {

    @Autowired
    private RestClientSettings restClientSettings;

    @Bean
	public HttpClient httpClient() {
        final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(restClientSettings.getMaxConnectionsPerHost());
        connectionManager.setMaxTotal(restClientSettings.getMaxTotalConnections());
        HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(connectionManager);
        httpClientBuilder.setRoutePlanner(new SystemDefaultRoutePlanner(ProxySelector.getDefault()));
        final CloseableHttpClient httpClient = httpClientBuilder.build();
        return httpClient;
    }
}
