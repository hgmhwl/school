package net.school_a.app.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import net.school_a.app.model.bean.GoodsDataModel;
import net.school_a.app.ui.viewholder.GoodsDataViewHolder;

/**
 * author：Anumbrella
 * Date：16/6/9 下午6:36
 */
public class GoodsAdapter extends RecyclerArrayAdapter<GoodsDataModel> {
    public GoodsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GoodsDataViewHolder(parent);
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
