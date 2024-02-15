package com.atipera.api.integration;

import com.atipera.api.exception.NoSuchRepositoryException;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class GitHubIntegration {
    private final Environment environment;
    private final RestTemplate restTemplate;
    public String executeSearch(String userName) {
        ResponseEntity<String> response;
        try {
            response = this.restTemplate.getForEntity(this.environment.getProperty("rest.api.endpoint") + userName + "/repos", String.class);
        } catch (HttpClientErrorException e) {
            throw new NoSuchRepositoryException(e.getMessage());
        }
        return response.getBody();
    }
}
