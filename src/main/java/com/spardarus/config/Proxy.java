package com.spardarus.config;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class Proxy {
    private static final String proxyEnable="true";
    private static final String proxyHost = "91.196.150.19";
    private static final int proxyPort = 30043;

    private static HttpHost getProxyHttpHost() {
        return new HttpHost(proxyHost, proxyPort);
    }
    public static DefaultBotOptions buildBotOptions() {
        DefaultBotOptions options = new DefaultBotOptions();
        RequestConfig config;
        if (proxyEnable.equals("true")) {
            config = RequestConfig.custom().setProxy(getProxyHttpHost()).build();
        } else {
            config = RequestConfig.custom().build();
        }
        options.setRequestConfig(config);
        return options;
    }
}
