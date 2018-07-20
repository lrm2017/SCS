package com.example.scs.database;

import org.litepal.crud.DataSupport;

/**
 * Created by 123 on 2018/7/20.
 */

public class login_state extends DataSupport {
    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
