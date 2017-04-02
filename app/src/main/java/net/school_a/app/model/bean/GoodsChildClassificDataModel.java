package net.school_a.app.model.bean;

import java.io.Serializable;

/**
 * Created by mac on 2017/3/13.
 * 商品大分类
 */

public class GoodsChildClassificDataModel implements Serializable {
    private String uuid;
    private String name;
    private String desc;
    // 父级id
    private String fatherId;

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

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }
}
