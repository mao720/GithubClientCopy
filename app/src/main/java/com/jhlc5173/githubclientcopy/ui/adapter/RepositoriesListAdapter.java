package com.jhlc5173.githubclientcopy.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.ImmutableList;
import com.jakewharton.rxbinding.view.RxView;
import com.jhlc5173.githubclientcopy.data.model.Repository;
import com.jhlc5173.githubclientcopy.ui.activity.RepositoriesListActivity;
import com.jhlc5173.githubclientcopy.ui.adapter.viewholder.RepositoriesViewHolder;
import com.jhlc5173.githubclientcopy.ui.adapter.viewholder.RepositoriesViewHolderFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.functions.Action1;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/17.
 */

public class RepositoriesListAdapter extends RecyclerView.Adapter {

    private RepositoriesListActivity repositoriesListActivity;
    private Map<Integer, RepositoriesViewHolderFactory> viewHolderFactories;
    private List<Repository> repositoryList = new ArrayList<>();

    public RepositoriesListAdapter(RepositoriesListActivity repositoriesListActivity, Map<Integer, RepositoriesViewHolderFactory> viewHolderFactories) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.viewHolderFactories = viewHolderFactories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = viewHolderFactories.get(viewType).createViewHolder(parent);
        RxView.clicks(viewHolder.itemView).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                onRepositoriesItemClicked(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RepositoriesViewHolder)holder).bind(repositoryList.get(position));
    }

    private void onRepositoriesItemClicked(int adapterPosition) {
        repositoriesListActivity.onRepositoryClick(repositoryList.get(adapterPosition));
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public void updateRepositoriesList(ImmutableList<Repository> repositories) {
        repositoryList.clear();
        repositoryList.addAll(repositories);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return repositoryList.get(position).stargazers_count >= 100 ? Repository.TYPE_BIG : Repository.TYPE_NORMAL;
    }
}
