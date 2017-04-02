package net.school_a.app.model.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mac on 2017/3/13.
 * 商品大分类
 */

public class GoodsClassificDataModel implements Serializable {
    private String uuid;
    private String name;
    private String desc;
    // 所属用户
    private String userUUID;
    // 小分类集合
    private ArrayList<GoodsChildClassificDataModel> list;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public ArrayList<GoodsChildClassificDataModel> getList() {
        return list;
    }

    public void setList(ArrayList<GoodsChildClassificDataModel> list) {
        this.list = list;
    }
}
