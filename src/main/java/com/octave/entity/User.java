package com.octave.entity;


import com.octave.util.regex.RegExAnno;
import com.octave.util.regex.RegExEnum;

public class User {

    private Integer userId;
    @RegExAnno(type = RegExEnum.USER_NAME)
    private String userName;
    @RegExAnno(type = RegExEnum.PASSWORD)
    private String password;
    private Integer type;
    @RegExAnno(type = RegExEnum.CALL_PHONE)
    private String tel;
    @RegExAnno(type = RegExEnum.EMAIL)
    private String email;
    private Integer locked;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", locked=" + locked +
                '}';
    }


}
