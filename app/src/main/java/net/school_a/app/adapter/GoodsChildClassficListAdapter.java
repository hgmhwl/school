package net.school_a.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.school_a.app.R;
import net.school_a.app.model.bean.GoodsChildClassificDataModel;

import java.util.ArrayList;

/**
 * author：Anumbrella
 * Date：16/5/26 下午7:21
 */
public class GoodsChildClassficListAdapter extends BaseAdapter {

    private GoodsChildClassificDataModel productType;

    private ArrayList<GoodsChildClassificDataModel> listProductType;

    private Context context;

    private Hoder hoder;


    public GoodsChildClassficListAdapter(Context context, ArrayList<GoodsChildClassificDataModel> listProductType) {
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
            convertView = convertView.inflate(context, R.layout.itemview_child_classfic, null);
            hoder = new Hoder(convertView);
            convertView.setTag(hoder);
        } else {
            hoder = (Hoder) convertView.getTag();
        }
        if (listProductType != null && listProductType.size() > 0) {
            productType = listProductType.get(position);
            hoder.textView.setText(productType.getName());
        }
        return convertView;
    }

    private static class Hoder {
        private TextView textView;

        public Hoder(View view) {
            textView = (TextView) view.findViewById(R.id.child_classfic_name);
        }
    }
}
