package com.spring.mybatis.bean;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5046972860468900599L;

    private Integer id;



    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }


}

