package com.ikook.jdbc;

/**
 * 实体类 User
 */
public class User {

    private Integer userid; //用户id
    private String username; //用户名
    private String password; //密码

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDao [userid=" + userid + ", username=" + username
                + ", password=" + password + "]";
    }
}
