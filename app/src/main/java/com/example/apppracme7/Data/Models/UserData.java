package com.example.apppracme7.Data.Models;

public class UserData {
    private String nickname;
    private String fName;
    private String sName;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserData(String nickname, String fName, String sName, String email, String password) {
        this.password = password;
        this.nickname = nickname;
        this.fName = fName;
        this.sName = sName;
        this.email = email;
    }
}
