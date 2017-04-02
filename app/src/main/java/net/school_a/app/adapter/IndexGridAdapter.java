package net.school_a.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.school_a.app.R;

/**
 * @author http://blog.csdn.net/finddreams
 * @Description:gridview的Adapter
 */
public class IndexGridAdapter extends BaseAdapter {
    private Context mContext;

    public String[] img_text = {"新增商品", "新增会员", "收银记账", "支出管理", "商品管理", "会员管理", "查询销售",
            "智能分析", "供应商管理", "挂单", "手机橱窗", "发短信"};
    public int[] imgs = {R.mipmap.icon_scgg, R.mipmap.icon_scgg,
            R.mipmap.icon_scgg, R.mipmap.icon_scgg,
            R.mipmap.icon_scgg, R.mipmap.icon_scgg,
            R.mipmap.icon_scgg, R.mipmap.icon_scgg,
            R.mipmap.icon_scgg, R.mipmap.icon_scgg,
            R.mipmap.icon_scgg, R.mipmap.icon_scgg};

    public IndexGridAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return img_text.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.grid_item, parent, false);
        }
        TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
        ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);
        iv.setBackgroundResource(imgs[position]);

        tv.setText(img_text[position]);
        return convertView;
    }

}
