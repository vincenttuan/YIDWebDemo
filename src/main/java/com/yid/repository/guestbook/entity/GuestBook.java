package com.yid.repository.guestbook.entity;

import java.util.Date;

public class GuestBook {
    private Integer id;
    private Category category;
    private String username;
    private String email;
    private String message;
    private Date updatetime;
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "GuestBook{" + "id=" + id + ", category=" + category + ", username=" + username + ", email=" + email + ", message=" + message + ", updatetime=" + updatetime + ", createtime=" + createtime + '}';
    }

    
    
}
