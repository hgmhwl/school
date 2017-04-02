package net.school_a.app.model.bean;

import java.io.Serializable;

/**
 * Created by mac on 2017/3/17.
 * 会员
 */

public class VipDataModel implements Serializable {
    private String id;
    // 会员名称
    private String name;
    // 会员卡号
    private String cardNo;
    // 会员电话号码
    private String phone;
    // 会员性别
    private int sex;
    // 会员生日
    private String bearthday;
    // 会员地址
    private String address;
    // 会员qq
    private String qq;
    // 会员微信号
    private String weixin;
    // 会员邮箱
    private String email;
    // 备注
    private String remark;
    // 会员头像地址
    private String headUrl;

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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBearthday() {
        return bearthday;
    }

    public void setBearthday(String bearthday) {
        this.bearthday = bearthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
