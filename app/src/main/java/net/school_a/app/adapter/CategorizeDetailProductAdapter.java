package net.school_a.app.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import net.school_a.app.model.bean.ListProductContentModel;
import net.school_a.app.ui.viewholder.CategorizeDetailProductViewHolder;

/**
 * author：Anumbrella
 * Date：16/6/4 下午7:14
 */
public class CategorizeDetailProductAdapter extends RecyclerArrayAdapter<ListProductContentModel> {

    public CategorizeDetailProductAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategorizeDetailProductViewHolder(parent);
    }


    public class TipSpanSizeLookUp extends GridSpanSizeLookup {

        public TipSpanSizeLookUp() {
            //列数默认为2
            super(2);
        }

        @Override
        public int getSpanSize(int position) {
            return 2;
        }
    }

    public TipSpanSizeLookUp obtainTipSpanSizeLookUp() {
        return new TipSpanSizeLookUp();
    }
}
