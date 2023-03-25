package cex.io.service;

public interface HttpClient {
    <T> T get(String url, Class<T> clazz);
}
