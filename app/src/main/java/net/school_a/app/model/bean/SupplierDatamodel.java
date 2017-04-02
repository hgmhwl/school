package net.school_a.app.model.bean;

import java.io.Serializable;

/**
 * Created by mac on 2017/3/8.
 * 供应商
 */

public class SupplierDatamodel implements Serializable {
    // 头像
    private String headUrl;
    // 供应商姓名
    private String name;
    // 联系电话
    private String phone;
    // 单位名称
    private String company;
    // 详细地址
    private String address;
    // 备注信息
    private String remark;
    // qq号码
    private String qq;
    // 微信号码
    private String weixin;
    // 支付宝账号
    private String alipay;
    // 银行卡号
    private String card;


    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
