package com.atipera.api.githubRepositorie;

import com.atipera.api.exception.ResponseBodyFormatException;
import com.atipera.api.exception.ResponseNullException;
import com.atipera.api.integration.GitHubIntegration;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GithubRepositoryServiceTests {
    @Mock
    private GitHubIntegration gitHubIntegration;
    @InjectMocks
    private GithubRepositoryService githubRepositoryService;
    @Test
    public void getNotForkedRepositoriesByUserName_FormatSuccessTest() {
        String response = """
            [
                {
                    "id": 665418348,
                    "node_id": "R_kgDOJ6l6bA",
                    "name": "cloud-commerce-sample-setup-1",
                    "full_name": "LeszekChojnacki/cloud-commerce-sample-setup-1",
                    "private": false,
                    "owner": {
                        "login": "LeszekChojnacki",
                        "id": 33976988,
                        "node_id": "MDQ6VXNlcjMzOTc2OTg4",
                        "avatar_url": "https://avatars.githubusercontent.com/u/33976988?v=4",
                        "gravatar_id": "",
                        "url": "https://api.github.com/users/LeszekChojnacki",
                        "html_url": "https://github.com/LeszekChojnacki",
                        "followers_url": "https://api.github.com/users/LeszekChojnacki/followers",
                        "following_url": "https://api.github.com/users/LeszekChojnacki/following{/other_user}",
                        "gists_url": "https://api.github.com/users/LeszekChojnacki/gists{/gist_id}",
                        "starred_url": "https://api.github.com/users/LeszekChojnacki/starred{/owner}{/repo}",
                        "subscriptions_url": "https://api.github.com/users/LeszekChojnacki/subscriptions",
                        "organizations_url": "https://api.github.com/users/LeszekChojnacki/orgs",
                        "repos_url": "https://api.github.com/users/LeszekChojnacki/repos",
                        "events_url": "https://api.github.com/users/LeszekChojnacki/events{/privacy}",
                        "received_events_url": "https://api.github.com/users/LeszekChojnacki/received_events",
                        "type": "User",
                        "site_admin": false
                    },
                    "html_url": "https://github.com/LeszekChojnacki/cloud-commerce-sample-setup-1",
                    "description": "Find the sample manifest.json and configuration files that you can use to build out your commerce repository in SAP Commerce Cloud.",
                    "fork": true,
                    "url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1",
                    "forks_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/forks",
                    "keys_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/keys{/key_id}",
                    "collaborators_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/collaborators{/collaborator}",
                    "teams_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/teams",
                    "hooks_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/hooks",
                    "issue_events_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/issues/events{/number}",
                    "events_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/events",
                    "assignees_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/assignees{/user}",
                    "branches_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/branches{/branch}",
                    "tags_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/tags",
                    "blobs_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/git/blobs{/sha}",
                    "git_tags_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/git/tags{/sha}",
                    "git_refs_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/git/refs{/sha}",
                    "trees_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/git/trees{/sha}",
                    "statuses_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/statuses/{sha}",
                    "languages_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/languages",
                    "stargazers_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/stargazers",
                    "contributors_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/contributors",
                    "subscribers_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/subscribers",
                    "subscription_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/subscription",
                    "commits_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/commits{/sha}",
                    "git_commits_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/git/commits{/sha}",
                    "comments_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/comments{/number}",
                    "issue_comment_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/issues/comments{/number}",
                    "contents_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/contents/{+path}",
                    "compare_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/compare/{base}...{head}",
                    "merges_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/merges",
                    "archive_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/{archive_format}{/ref}",
                    "downloads_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/downloads",
                    "issues_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/issues{/number}",
                    "pulls_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/pulls{/number}",
                    "milestones_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/milestones{/number}",
                    "notifications_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/notifications{?since,all,participating}",
                    "labels_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/labels{/name}",
                    "releases_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/releases{/id}",
                    "deployments_url": "https://api.github.com/repos/LeszekChojnacki/cloud-commerce-sample-setup-1/deployments",
                    "created_at": "2023-07-12T06:55:41Z",
                    "updated_at": "2023-07-12T06:55:41Z",
                    "pushed_at": "2023-07-12T12:00:17Z",
                    "git_url": "git://github.com/LeszekChojnacki/cloud-commerce-sample-setup-1.git",
                    "ssh_url": "git@github.com:LeszekChojnacki/cloud-commerce-sample-setup-1.git",
                    "clone_url": "https://github.com/LeszekChojnacki/cloud-commerce-sample-setup-1.git",
                    "svn_url": "https://github.com/LeszekChojnacki/cloud-commerce-sample-setup-1",
                    "homepage": "",
                    "size": 14887,
                    "stargazers_count": 0,
                    "watchers_count": 0,
                    "language": null,
                    "has_issues": false,
                    "has_projects": true,
                    "has_downloads": true,
                    "has_wiki": false,
                    "has_pages": false,
                    "has_discussions": false,
                    "forks_count": 0,
                    "mirror_url": null,
                    "archived": false,
                    "disabled": false,
                    "open_issues_count": 0,
                    "license": null,
                    "allow_forking": true,
                    "is_template": false,
                    "web_commit_signoff_required": false,
                    "topics": [],
                    "visibility": "public",
                    "forks": 0,
                    "open_issues": 0,
                    "watchers": 0,
                    "default_branch": "main"
                },
                {
                    "id": 200085396,
                    "node_id": "MDEwOlJlcG9zaXRvcnkyMDAwODUzOTY=",
                    "name": "Engineering-Project",
                    "full_name": "LeszekChojnacki/Engineering-Project",
                    "private": false,
                    "owner": {
                        "login": "LeszekChojnacki",
                        "id": 33976988,
                        "node_id": "MDQ6VXNlcjMzOTc2OTg4",
                        "avatar_url": "https://avatars.githubusercontent.com/u/33976988?v=4",
                        "gravatar_id": "",
                        "url": "https://api.github.com/users/LeszekChojnacki",
                        "html_url": "https://github.com/LeszekChojnacki",
                        "followers_url": "https://api.github.com/users/LeszekChojnacki/followers",
                        "following_url": "https://api.github.com/users/LeszekChojnacki/following{/other_user}",
                        "gists_url": "https://api.github.com/users/LeszekChojnacki/gists{/gist_id}",
                        "starred_url": "https://api.github.com/users/LeszekChojnacki/starred{/owner}{/repo}",
                        "subscriptions_url": "https://api.github.com/users/LeszekChojnacki/subscriptions",
                        "organizations_url": "https://api.github.com/users/LeszekChojnacki/orgs",
                        "repos_url": "https://api.github.com/users/LeszekChojnacki/repos",
                        "events_url": "https://api.github.com/users/LeszekChojnacki/events{/privacy}",
                        "received_events_url": "https://api.github.com/users/LeszekChojnacki/received_events",
                        "type": "User",
                        "site_admin": false
                    },
                    "html_url": "https://github.com/LeszekChojnacki/Engineering-Project",
                    "description": "A simple project that visualizes the people distribution according to a certain surname in Poland",
                    "fork": false,
                    "url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project",
                    "forks_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/forks",
                    "keys_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/keys{/key_id}",
                    "collaborators_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/collaborators{/collaborator}",
                    "teams_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/teams",
                    "hooks_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/hooks",
                    "issue_events_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/issues/events{/number}",
                    "events_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/events",
                    "assignees_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/assignees{/user}",
                    "branches_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/branches{/branch}",
                    "tags_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/tags",
                    "blobs_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/git/blobs{/sha}",
                    "git_tags_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/git/tags{/sha}",
                    "git_refs_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/git/refs{/sha}",
                    "trees_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/git/trees{/sha}",
                    "statuses_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/statuses/{sha}",
                    "languages_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/languages",
                    "stargazers_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/stargazers",
                    "contributors_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/contributors",
                    "subscribers_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/subscribers",
                    "subscription_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/subscription",
                    "commits_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/commits{/sha}",
                    "git_commits_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/git/commits{/sha}",
                    "comments_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/comments{/number}",
                    "issue_comment_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/issues/comments{/number}",
                    "contents_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/contents/{+path}",
                    "compare_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/compare/{base}...{head}",
                    "merges_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/merges",
                    "archive_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/{archive_format}{/ref}",
                    "downloads_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/downloads",
                    "issues_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/issues{/number}",
                    "pulls_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/pulls{/number}",
                    "milestones_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/milestones{/number}",
                    "notifications_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/notifications{?since,all,participating}",
                    "labels_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/labels{/name}",
                    "releases_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/releases{/id}",
                    "deployments_url": "https://api.github.com/repos/LeszekChojnacki/Engineering-Project/deployments",
                    "created_at": "2019-08-01T16:34:28Z",
                    "updated_at": "2023-12-15T01:58:02Z",
                    "pushed_at": "2024-01-11T18:47:43Z",
                    "git_url": "git://github.com/LeszekChojnacki/Engineering-Project.git",
                    "ssh_url": "git@github.com:LeszekChojnacki/Engineering-Project.git",
                    "clone_url": "https://github.com/LeszekChojnacki/Engineering-Project.git",
                    "svn_url": "https://github.com/LeszekChojnacki/Engineering-Project",
                    "homepage": null,
                    "size": 33310,
                    "stargazers_count": 0,
                    "watchers_count": 0,
                    "language": "JavaScript",
                    "has_issues": true,
                    "has_projects": true,
                    "has_downloads": true,
                    "has_wiki": true,
                    "has_pages": false,
                    "has_discussions": false,
                    "forks_count": 0,
                    "mirror_url": null,
                    "archived": false,
                    "disabled": false,
                    "open_issues_count": 9,
                    "license": null,
                    "allow_forking": true,
                    "is_template": false,
                    "web_commit_signoff_required": false,
                    "topics": [],
                    "visibility": "public",
                    "forks": 0,
                    "open_issues": 9,
                    "watchers": 0,
                    "default_branch": "master"
                }
            ]
        """;
        Mockito.when(gitHubIntegration.executeSearch(Mockito.any())).thenReturn(response);
        List<JsonNode> repositories = this.githubRepositoryService.getNotForkedRepositoriesByUserName("userName");
        Assertions.assertEquals(1, repositories.size());
    }
    @Test
    public void getNotForkedRepositoriesByUserName_FormatFailedTest() {
        String response = " {[}";
        Mockito.when(gitHubIntegration.executeSearch(Mockito.any())).thenReturn(response);
        Assertions.assertThrows(ResponseBodyFormatException.class, ()-> {
            this.githubRepositoryService.getNotForkedRepositoriesByUserName("userName");
        });
    }
    @Test
    public void getNotForkedRepositoriesByUserName_GitHubIntegrationFailedTest() {
        Mockito.when(gitHubIntegration.executeSearch(Mockito.any())).thenReturn(null);
        Assertions.assertThrows(ResponseNullException.class, ()-> {
            this.githubRepositoryService.getNotForkedRepositoriesByUserName("userName");
        });
    }
}
