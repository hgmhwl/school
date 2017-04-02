package net.school_a.app.ui.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import net.school_a.app.model.bean.ListProductContentModel;
import net.school_a.app.ui.activity.DetailContentActivity;
import net.school_a.app.ui.fragment.DetailContentFragment;

/**
 * author：Anumbrella
 * Date：16/5/26 上午10:52
 */
public class ListProductContentViewHolder extends BaseViewHolder<ListProductContentModel> implements View.OnClickListener {

    private SimpleDraweeView simpleDraweeView;
    private CardView cardView;
    private TextView title;
    private TextView price;
    private ListProductContentModel data;

    public ListProductContentViewHolder(ViewGroup parent) {
        super(parent, net.school_a.app.R.layout.itemview_listproduct_content);
        simpleDraweeView = $(net.school_a.app.R.id.list_product_img);
        title = $(net.school_a.app.R.id.list_product_title);
        price = $(net.school_a.app.R.id.list_product_price);
        cardView = $(net.school_a.app.R.id.list_product_cardview);
    }

    @Override
    public void setData(ListProductContentModel data) {
        super.setData(data);
        this.data = data;
        simpleDraweeView.setImageURI(Uri.parse(data.getImageUrl()));
        title.setText(data.getTitle());
        price.setText("￥ " + data.getPrice());
        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case net.school_a.app.R.id.list_product_cardview:
                intent.putExtra(DetailContentFragment.ARG_ITEM_INFO_LISTPRODUCT, data);
                break;
        }
        intent.setClass(getContext(), DetailContentActivity.class);
        getContext().startActivity(intent);

    }
}
