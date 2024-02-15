package com.atipera.api.githubRepositorie;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/repositories")
@AllArgsConstructor
public class GithubRepositoryController {
    private GithubRepositoryService githubRepositoryService;
    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<JsonNode> getRepositoriesByUserName(@RequestParam(required = false, value = "user") String userName) {
        return this.githubRepositoryService.getNotForkedRepositoriesByUserName(userName);
    }
}
