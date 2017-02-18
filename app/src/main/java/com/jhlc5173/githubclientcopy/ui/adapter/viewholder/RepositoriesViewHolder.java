package com.jhlc5173.githubclientcopy.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jhlc5173.githubclientcopy.data.model.Repository;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/17.
 */

public abstract class RepositoriesViewHolder extends RecyclerView.ViewHolder {

    public RepositoriesViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Repository repository);
}
