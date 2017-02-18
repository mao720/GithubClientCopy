package com.jhlc5173.githubclientcopy.utils;

import android.text.TextUtils;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/6.
 */

public class Validator {
    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }
}
