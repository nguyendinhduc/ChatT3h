package com.t3h.chatfun;


public class Friend {
    private String displayNameFriend;
    private int id;
    private String friendAvatar;
    private int friendId;
    private boolean isOnline;
    private String content;
    private String created;

    public String getDisplayNameFriend() {
        return displayNameFriend;
    }

    public void setDisplayNameFriend(String displayNameFriend) {
        this.displayNameFriend = displayNameFriend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFriendAvatar() {
        return friendAvatar;
    }

    public void setFriendAvatar(String friendAvatar) {
        this.friendAvatar = friendAvatar;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
