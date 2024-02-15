package com.atipera.api.integration;

import com.atipera.api.exception.NoSuchRepositoryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class GitHubIntegrationTest {
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private Environment environment;
    @InjectMocks
    private GitHubIntegration gitHubIntegration;
    @Test
    public void executeSearch_manage404ResponseSuccessfulTest() {
        Mockito.when(this.environment.getProperty(Mockito.any())).thenReturn("https://api.github.com/users/");
        Mockito.when(this.restTemplate.getForEntity(Mockito.anyString(),Mockito.any())).thenThrow(HttpClientErrorException.class);
        Assertions.assertThrows(NoSuchRepositoryException.class, ()-> {
            gitHubIntegration.executeSearch("userName");
        });
    }

}