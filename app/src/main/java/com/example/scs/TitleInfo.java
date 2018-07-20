package com.example.scs;

import java.util.List;

/**
 * Created by 123 on 2018/7/18.
 */

class TitleInfo {
    private String            title;
    private List<ContentInfo> info;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ContentInfo> getInfo() {
        return info;
    }

    public void setInfo(List<ContentInfo> info) {
        this.info = info;
    }
}


