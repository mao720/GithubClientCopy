package com.jhlc5173.githubclientcopy.data.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/16.
 */

public class RepositoresResponse {
    /**
     * id : 75295014
     * name : Android5.0Demo
     * full_name : mao720/Android5.0Demo
     * owner : {"login":"mao720","id":20820337,"avatar_url":"https://avatars.githubusercontent.com/u/20820337?v=3","gravatar_id":"","url":"https://api.github.com/users/mao720","html_url":"https://github.com/mao720","followers_url":"https://api.github.com/users/mao720/followers","following_url":"https://api.github.com/users/mao720/following{/other_user}","gists_url":"https://api.github.com/users/mao720/gists{/gist_id}","starred_url":"https://api.github.com/users/mao720/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/mao720/subscriptions","organizations_url":"https://api.github.com/users/mao720/orgs","repos_url":"https://api.github.com/users/mao720/repos","events_url":"https://api.github.com/users/mao720/events{/privacy}","received_events_url":"https://api.github.com/users/mao720/received_events","type":"User","site_admin":false}
     * private : false
     * html_url : https://github.com/mao720/Android5.0Demo
     * description : null
     * fork : false
     * url : https://api.github.com/repos/mao720/Android5.0Demo
     * forks_url : https://api.github.com/repos/mao720/Android5.0Demo/forks
     * keys_url : https://api.github.com/repos/mao720/Android5.0Demo/keys{/key_id}
     * collaborators_url : https://api.github.com/repos/mao720/Android5.0Demo/collaborators{/collaborator}
     * teams_url : https://api.github.com/repos/mao720/Android5.0Demo/teams
     * hooks_url : https://api.github.com/repos/mao720/Android5.0Demo/hooks
     * issue_events_url : https://api.github.com/repos/mao720/Android5.0Demo/issues/events{/number}
     * events_url : https://api.github.com/repos/mao720/Android5.0Demo/events
     * assignees_url : https://api.github.com/repos/mao720/Android5.0Demo/assignees{/user}
     * branches_url : https://api.github.com/repos/mao720/Android5.0Demo/branches{/branch}
     * tags_url : https://api.github.com/repos/mao720/Android5.0Demo/tags
     * blobs_url : https://api.github.com/repos/mao720/Android5.0Demo/git/blobs{/sha}
     * git_tags_url : https://api.github.com/repos/mao720/Android5.0Demo/git/tags{/sha}
     * git_refs_url : https://api.github.com/repos/mao720/Android5.0Demo/git/refs{/sha}
     * trees_url : https://api.github.com/repos/mao720/Android5.0Demo/git/trees{/sha}
     * statuses_url : https://api.github.com/repos/mao720/Android5.0Demo/statuses/{sha}
     * languages_url : https://api.github.com/repos/mao720/Android5.0Demo/languages
     * stargazers_url : https://api.github.com/repos/mao720/Android5.0Demo/stargazers
     * contributors_url : https://api.github.com/repos/mao720/Android5.0Demo/contributors
     * subscribers_url : https://api.github.com/repos/mao720/Android5.0Demo/subscribers
     * subscription_url : https://api.github.com/repos/mao720/Android5.0Demo/subscription
     * commits_url : https://api.github.com/repos/mao720/Android5.0Demo/commits{/sha}
     * git_commits_url : https://api.github.com/repos/mao720/Android5.0Demo/git/commits{/sha}
     * comments_url : https://api.github.com/repos/mao720/Android5.0Demo/comments{/number}
     * issue_comment_url : https://api.github.com/repos/mao720/Android5.0Demo/issues/comments{/number}
     * contents_url : https://api.github.com/repos/mao720/Android5.0Demo/contents/{+path}
     * compare_url : https://api.github.com/repos/mao720/Android5.0Demo/compare/{base}...{head}
     * merges_url : https://api.github.com/repos/mao720/Android5.0Demo/merges
     * archive_url : https://api.github.com/repos/mao720/Android5.0Demo/{archive_format}{/ref}
     * downloads_url : https://api.github.com/repos/mao720/Android5.0Demo/downloads
     * issues_url : https://api.github.com/repos/mao720/Android5.0Demo/issues{/number}
     * pulls_url : https://api.github.com/repos/mao720/Android5.0Demo/pulls{/number}
     * milestones_url : https://api.github.com/repos/mao720/Android5.0Demo/milestones{/number}
     * notifications_url : https://api.github.com/repos/mao720/Android5.0Demo/notifications{?since,all,participating}
     * labels_url : https://api.github.com/repos/mao720/Android5.0Demo/labels{/name}
     * releases_url : https://api.github.com/repos/mao720/Android5.0Demo/releases{/id}
     * deployments_url : https://api.github.com/repos/mao720/Android5.0Demo/deployments
     * created_at : 2016-12-01T13:27:29Z
     * updated_at : 2016-12-03T16:40:12Z
     * pushed_at : 2016-12-03T16:40:11Z
     * git_url : git://github.com/mao720/Android5.0Demo.git
     * ssh_url : git@github.com:mao720/Android5.0Demo.git
     * clone_url : https://github.com/mao720/Android5.0Demo.git
     * svn_url : https://github.com/mao720/Android5.0Demo
     * homepage : null
     * size : 5060
     * stargazers_count : 0
     * watchers_count : 0
     * language : Java
     * has_issues : true
     * has_downloads : true
     * has_wiki : true
     * has_pages : false
     * forks_count : 0
     * mirror_url : null
     * open_issues_count : 0
     * forks : 0
     * open_issues : 0
     * watchers : 0
     * default_branch : master
     */

    public int id;
    public String name;
    public String full_name;
    public OwnerBean owner;
    @SerializedName("private")
    public boolean privateX;
    public String html_url;
    public Object description;
    public boolean fork;
    public String url;
    public String forks_url;
    public String keys_url;
    public String collaborators_url;
    public String teams_url;
    public String hooks_url;
    public String issue_events_url;
    public String events_url;
    public String assignees_url;
    public String branches_url;
    public String tags_url;
    public String blobs_url;
    public String git_tags_url;
    public String git_refs_url;
    public String trees_url;
    public String statuses_url;
    public String languages_url;
    public String stargazers_url;
    public String contributors_url;
    public String subscribers_url;
    public String subscription_url;
    public String commits_url;
    public String git_commits_url;
    public String comments_url;
    public String issue_comment_url;
    public String contents_url;
    public String compare_url;
    public String merges_url;
    public String archive_url;
    public String downloads_url;
    public String issues_url;
    public String pulls_url;
    public String milestones_url;
    public String notifications_url;
    public String labels_url;
    public String releases_url;
    public String deployments_url;
    public String created_at;
    public String updated_at;
    public String pushed_at;
    public String git_url;
    public String ssh_url;
    public String clone_url;
    public String svn_url;
    public Object homepage;
    public int size;
    public int stargazers_count;
    public int watchers_count;
    public String language;
    public boolean has_issues;
    public boolean has_downloads;
    public boolean has_wiki;
    public boolean has_pages;
    public int forks_count;
    public Object mirror_url;
    public int open_issues_count;
    public int forks;
    public int open_issues;
    public int watchers;
    public String default_branch;
    
    public static class OwnerBean {
        /**
         * login : mao720
         * id : 20820337
         * avatar_url : https://avatars.githubusercontent.com/u/20820337?v=3
         * gravatar_id : 
         * url : https://api.github.com/users/mao720
         * html_url : https://github.com/mao720
         * followers_url : https://api.github.com/users/mao720/followers
         * following_url : https://api.github.com/users/mao720/following{/other_user}
         * gists_url : https://api.github.com/users/mao720/gists{/gist_id}
         * starred_url : https://api.github.com/users/mao720/starred{/owner}{/repo}
         * subscriptions_url : https://api.github.com/users/mao720/subscriptions
         * organizations_url : https://api.github.com/users/mao720/orgs
         * repos_url : https://api.github.com/users/mao720/repos
         * events_url : https://api.github.com/users/mao720/events{/privacy}
         * received_events_url : https://api.github.com/users/mao720/received_events
         * type : User
         * site_admin : false
         */

        public String login;
        public int id;
        public String avatar_url;
        public String gravatar_id;
        public String url;
        public String html_url;
        public String followers_url;
        public String following_url;
        public String gists_url;
        public String starred_url;
        public String subscriptions_url;
        public String organizations_url;
        public String repos_url;
        public String events_url;
        public String received_events_url;
        public String type;
        public boolean site_admin;
    }
}
