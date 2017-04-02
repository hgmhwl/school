package net.school_a.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.school_a.app.R;
import net.school_a.app.model.bean.ProductTypeModel;

import java.util.ArrayList;

/**
 * author：Anumbrella
 * Date：16/5/26 下午7:21
 */
public class SaleGoodsAdapter extends BaseAdapter {

    private ProductTypeModel productType;

    private ArrayList<ProductTypeModel> listProductType;

    private Context context;

    private Hoder hoder;
    // 点击的次数
    private int num = 0;
    // 商品总价
    private double price = 0.0;
    private OnAddClickListener onAddClickListener;//定义对象


    public SaleGoodsAdapter(Context context, ArrayList<ProductTypeModel> listProductType) {
        this.context = context;
        this.listProductType = listProductType;
    }


    @Override
    public int getCount() {
        if (listProductType != null && listProductType.size() > 0) {
            return listProductType.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return listProductType.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.item_sale_goods, null);
            hoder = new Hoder(convertView);
            convertView.setTag(hoder);
        } else {
            hoder = (Hoder) convertView.getTag();
        }
        if (listProductType != null && listProductType.size() > 0) {
            productType = listProductType.get(position);
            hoder.imageView.setBackgroundResource(productType.getIcon());
            hoder.textView.setText(productType.getTitleName());
        }
        hoder.img_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;// 每点击一次，增加1
                price++;
                if (onAddClickListener != null) {
                    onAddClickListener.onAddClick(num, price);
                }
            }
        });
        return convertView;
    }

    private static class Hoder {
        private TextView textView;
        private ImageView imageView;
        private ImageView img_Add;

        public Hoder(View view) {
            textView = (TextView) view.findViewById(R.id.productName_gridView);
            imageView = (ImageView) view.findViewById(R.id.icon_gridView);
            img_Add = (ImageView) view.findViewById(R.id.productName_add);
        }
    }

    // 添加商品按钮接口定义
    public interface OnAddClickListener {
        void onAddClick(int num, double totalPrice);
        //void onLocateClick();
    }

    public void setOnAddClickListener(OnAddClickListener listener) {
        this.onAddClickListener = listener;
    }
}
