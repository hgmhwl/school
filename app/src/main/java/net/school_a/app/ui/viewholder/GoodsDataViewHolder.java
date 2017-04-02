package net.school_a.app.ui.viewholder;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import net.school_a.app.R;
import net.school_a.app.model.bean.GoodsDataModel;
import net.school_a.app.ui.activity.GoodsManagerActivity;

/**
 * author：Anumbrella
 * Date：16/6/9 下午6:37
 * 商品
 */
public class GoodsDataViewHolder extends BaseViewHolder<GoodsDataModel> {


    private GoodsDataModel data;

    private static GoodsManagerActivity object = new GoodsManagerActivity();


    // 头像
    private SimpleDraweeView icon;

    private TextView name;

    private TextView price;

    private TextView format;

    private TextView code;

    private TextView stock;

    public GoodsDataViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_goods);
        icon = $(R.id.item_goods_icon);
        name = $(R.id.item_goods_name);
        price = $(R.id.item_goods_price);
        format = $(R.id.item_goods_format);
        code = $(R.id.item_goods_code);
        stock = $(R.id.item_goods_stock);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setData(GoodsDataModel model) {
        super.setData(model);
        this.data = model;
        //icon.setImageURI(Uri.parse(data.getImg()));
        name.setText(data.getName());
        price.setText("¥ " + data.getPrice());
        format.setText("|" + data.getFormat());
        code.setText("条码:" + data.getCodeStr());
        stock.setText("库存:" + data.getStock() + "件");
    }
}
