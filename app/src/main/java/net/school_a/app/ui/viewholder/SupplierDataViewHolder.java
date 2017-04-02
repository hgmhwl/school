package net.school_a.app.ui.viewholder;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import net.school_a.app.R;
import net.school_a.app.model.bean.SupplierDatamodel;
import net.school_a.app.ui.activity.SupplierManagerActivity;

/**
 * author：Anumbrella
 * Date：16/6/9 下午6:37
 * 供应商
 */
public class SupplierDataViewHolder extends BaseViewHolder<SupplierDatamodel> {


    private SupplierDatamodel data;

    private static SupplierManagerActivity object = new SupplierManagerActivity();


    // 头像
    private SimpleDraweeView icon;

    private TextView name;

    private TextView phone;

    private TextView goodsNum;

    public SupplierDataViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_supplier);
        icon = $(R.id.item_supplier_icon);
        name = $(R.id.item_supplier_name);
        phone = $(R.id.item_supplier_phone);
        goodsNum = $(R.id.item_supplier_num);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setData(SupplierDatamodel supplierDatamodel) {
        super.setData(supplierDatamodel);
        this.data = supplierDatamodel;
        //icon.setImageURI(Uri.parse(data.getImg()));
        name.setText(data.getName());
        phone.setText(data.getPhone());
        goodsNum.setText("供应2种商品");
    }
}
