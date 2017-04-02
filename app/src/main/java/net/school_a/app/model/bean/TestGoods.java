package net.school_a.app.model.bean;

import java.io.Serializable;

/**
 * Created by mac on 2017/3/25.
 * 测试商品
 */

public class TestGoods implements Serializable {
    private String id;
    private String name;
    private double price;
    private String code;
    private int store;
    private int res;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
