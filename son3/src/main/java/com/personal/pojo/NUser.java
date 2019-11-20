package com.personal.pojo;

import com.personal.web.controller.ValiGroup1;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NUser {
    //还得是包装类
    @Range(min = 5,max = 18,message = "{uID.length.error}")
    private long uID;

    //该校验只适用于（生效于）该分组

    //该注解只对字符串起作用
    @Size(min = 5,max = 20,message = "{nickname.length.error}",groups = {ValiGroup1.class})
    private String nickname;

    //该校验既适用于1分组又适用于2分组
    //@NotNull(message = "{password.length.isnull}",groups = {ValiGroup1.class, ValiGroup2.class})
    @NotEmpty(message = "{password.isnull}")
    private String password;

    public NUser() {
    }

    public NUser(long uID, String nickname, String password) {
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
        return "NUser{" +
                "uID=" + uID +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
