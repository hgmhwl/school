package net.school_a.app.ui.viewholder;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import net.school_a.app.model.bean.CommentProductDataModel;
import net.school_a.app.utils.BaseUtils;

/**
 * author：Anumbrella
 * Date：16/6/2 上午11:55
 */
public class ProductDetailViewHoler extends BaseViewHolder<CommentProductDataModel> {


    private CommentProductDataModel.ProductDetailData data;

    private TextView detail_product_price;

    private TextView detail_product_title;

    private SimpleDraweeView product_detail_img;

    private TextView phone_storage;

    private TextView phone_carrieroperator;

    private TextView phone_color;

    private LinearLayout phone_select;

    public ProductDetailViewHoler(ViewGroup parent) {
        super(parent, net.school_a.app.R.layout.itemview_product_detail);
        detail_product_price = $(net.school_a.app.R.id.detail_product_price);
        detail_product_title = $(net.school_a.app.R.id.detail_product_title);
        product_detail_img = $(net.school_a.app.R.id.product_detail_img);
        phone_storage = $(net.school_a.app.R.id.phone_storage);
        phone_carrieroperator = $(net.school_a.app.R.id.phone_carrieroperator);
        phone_color = $(net.school_a.app.R.id.phone_color);
        phone_select = $(net.school_a.app.R.id.phone_select);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setData(CommentProductDataModel productDataModel) {
        super.setData(productDataModel);
        this.data = productDataModel.getProductDetailData();

        String storage = BaseUtils.transform("storage", String.valueOf(data.getPhoneStorage()));
        String carrieroperator = BaseUtils.transform("carrieroperator", String.valueOf(data.getPhoneCarrieroperator()));
        String color = BaseUtils.transform("color", String.valueOf(data.getPhoneColor()));
        if (storage != null && carrieroperator != null && color != null) {
            phone_storage.setText(storage);
            phone_carrieroperator.setText(carrieroperator);
            phone_color.setText(color);
        } else {
            phone_select.setVisibility(View.GONE);
        }
        detail_product_title.setText(data.getProductName());
        detail_product_price.setText("￥ " + data.getPrice());
        product_detail_img.setImageURI(Uri.parse(data.getImg()));
    }

}
