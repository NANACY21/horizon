package com.personal.pojo;

public class User {
    private long uID;
    private String nickname;
    private String password;

    public User() {
    }

    public User(long uID, String nickname, String password) {
        this.uID = uID;
        this.nickname = nickname;
        this.password = password;
    }

    public long getuID() {
        return uID;
    }

    public void setuID(long uID) {
        this.uID = uID;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID=" + uID +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
