package com.example.pos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ThemeService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Replace with your backend URL
    private static final String THEME_URL = System.getProperty("theme.url", "http://localhost:8080/theme");

    public Theme fetchTheme() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(THEME_URL))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            return objectMapper.readValue(response.body(), Theme.class);
        }
        throw new IOException("Failed to fetch theme: HTTP " + response.statusCode());
    }
}
