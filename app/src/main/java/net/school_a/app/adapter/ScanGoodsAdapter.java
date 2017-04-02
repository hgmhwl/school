package net.school_a.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.school_a.app.R;
import net.school_a.app.model.bean.TestGoods;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mac on 2017/2/9.
 * 消息适配器
 */

public class ScanGoodsAdapter extends Adapter<TestGoods> {

    public ScanGoodsAdapter(Context context, List<TestGoods> list) {
        super(context, list);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected View ourView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final TestGoods bean = list.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_scan_goods, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            resetViewHolder(viewHolder);
        }
        viewHolder.tv_Name.setText(bean.getName());
        viewHolder.tv_Store.setText("库存：" + bean.getStore());
        viewHolder.tv_Price.setText("¥：" + bean.getPrice());
        viewHolder.imageView.setImageResource(bean.getRes());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.scan_goods_name)
        TextView tv_Name;
        @BindView(R.id.scan_goods_store)
        TextView tv_Store;
        @BindView(R.id.scan_goods_price)
        TextView tv_Price;
        @BindView(R.id.scan_goods_img)
        ImageView imageView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private void resetViewHolder(ViewHolder p_ViewHolder) {
        p_ViewHolder.tv_Name.setText(null);
        p_ViewHolder.tv_Store.setText(null);
        p_ViewHolder.tv_Price.setText(null);
        p_ViewHolder.imageView.setImageBitmap(null);
    }
}
