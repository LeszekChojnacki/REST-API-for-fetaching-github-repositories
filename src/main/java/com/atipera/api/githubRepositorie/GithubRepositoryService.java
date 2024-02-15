package com.atipera.api.githubRepositorie;

import com.atipera.api.exception.ResponseBodyFormatException;
import com.atipera.api.exception.ResponseNullException;
import com.atipera.api.integration.GitHubIntegration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class GithubRepositoryService {
    private GitHubIntegration gitHubIntegration;
    public List<JsonNode> getNotForkedRepositoriesByUserName(String userName) {
        String response = this.gitHubIntegration.executeSearch(userName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Iterator<JsonNode> nodes = objectMapper.readTree(response).iterator();
            List<JsonNode> filteredResponse = new ArrayList<JsonNode>();
            while (nodes.hasNext()) {
                JsonNode nextRepository = nodes.next();
                if(!nextRepository.get("fork").booleanValue()) {
                    filteredResponse.add(nextRepository);
                }
            }
            return filteredResponse;
        } catch (JsonProcessingException e) {
            throw new ResponseBodyFormatException(String.format("REST Response body JSON format not compatible: %s", response));
        } catch (IllegalArgumentException e) {
            throw new ResponseNullException(String.format("REST Response NULL: %s", response));
        }
    }
}
