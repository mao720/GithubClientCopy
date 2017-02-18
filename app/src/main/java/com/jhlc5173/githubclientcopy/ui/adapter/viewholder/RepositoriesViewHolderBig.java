package com.jhlc5173.githubclientcopy.ui.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;
import com.jhlc5173.githubclientcopy.R;
import com.jhlc5173.githubclientcopy.data.model.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/17.
 */
@AutoFactory(implementing = RepositoriesViewHolderFactory.class)
public class RepositoriesViewHolderBig extends RepositoriesViewHolder {
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvStars)
    TextView tvStars;
    @BindView(R.id.tvForks)
    TextView tvForks;

    public RepositoriesViewHolderBig(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_normal, parent, false));
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bind(Repository repository) {
        tvName.setText(repository.name);
        tvStars.setText(String.valueOf(repository.stargazers_count));
        tvForks.setText(String.valueOf(repository.forks_count));
    }
}
