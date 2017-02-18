package com.jhlc5173.githubclientcopy.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.Policy;

import javax.inject.Scope;

/**
 * Description:
 * Created by MaoJunFeng on 2017/2/7.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
