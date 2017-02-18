package com.jhlc5173.githubclientcopy.data.model;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/17.
 */

public class Repository {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BIG = 1;
    public static final int TYPE_FEATURED = 2;
    public long id;
    public String name;
    public String url;
    public int stargazers_count;
    public int forks_count;
}
