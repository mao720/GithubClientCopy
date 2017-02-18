package com.jhlc5173.githubclientcopy.data.api;

import com.google.common.collect.ImmutableList;
import com.jhlc5173.githubclientcopy.data.api.response.RepositoresResponse;
import com.jhlc5173.githubclientcopy.data.model.Repository;
import com.jhlc5173.githubclientcopy.data.model.User;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/16.
 */
public class RepositoriesManager {

    private User user;
    private GithubApiService githubApiService;

    public RepositoriesManager(User user, GithubApiService githubApiService) {
        this.user = user;
        this.githubApiService = githubApiService;
    }

    public Observable<ImmutableList<Repository>> getUserRepositores() {
        return githubApiService.getUserRepositories(user.login)
                .map(new Func1<List<RepositoresResponse>, ImmutableList<Repository>>() {
                    @Override
                    public ImmutableList<Repository> call(List<RepositoresResponse> repositoresResponses) {
                        ImmutableList.Builder<Repository> builder = ImmutableList.builder();
                        for (RepositoresResponse repositoresResponse : repositoresResponses) {
                            Repository repository = new Repository();
                            repository.id = repositoresResponse.id;
                            repository.name = repositoresResponse.name;
                            repository.url = repositoresResponse.url;
                            repository.stargazers_count = repositoresResponse.stargazers_count;
                            repository.forks_count = repositoresResponse.forks_count;
                            builder.add(repository);
                        }
                        return builder.build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
