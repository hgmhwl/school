package net.school_a.app.ui.viewholder;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import net.school_a.app.R;
import net.school_a.app.model.bean.VipDataModel;
import net.school_a.app.ui.activity.VipManagerActivity;

/**
 * author：Anumbrella
 * Date：16/6/9 下午6:37
 * 商品
 */
public class VipDataViewHolder extends BaseViewHolder<VipDataModel> {


    private VipDataModel data;

    private static VipManagerActivity object = new VipManagerActivity();


    // 头像
    private SimpleDraweeView icon;

    private TextView name;

    private TextView phone;

    public VipDataViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_vip);
        icon = $(R.id.item_vip_icon);
        name = $(R.id.item_vip_name);
        phone = $(R.id.item_vip_phone);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setData(VipDataModel model) {
        super.setData(model);
        this.data = model;
        name.setText(data.getName());
        phone.setText(data.getPhone());
    }
}
