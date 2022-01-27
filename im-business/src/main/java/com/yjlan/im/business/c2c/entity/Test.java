package com.yjlan.im.business.c2c.entity;

public class Test {
    private Integer id;

    private String account;

    public Test(Integer id, String account) {
        this.id = id;
        this.account = account;
    }

    public Test() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
}