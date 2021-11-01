package com.xiaoxiaohui;

import java.util.ArrayList;
import java.util.List;

public class CommunityList {
    List<Community> communityList;

    public CommunityList() {
        communityList = new ArrayList<>();
    }

    public List<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }
    public Community getCommunity(int i){
        return communityList.get(i);
    }
    public void addCommunity(Community community){
        communityList.add(community);
    }
    public void deletCommunity(int i){
        communityList.remove(i);
    }
}
