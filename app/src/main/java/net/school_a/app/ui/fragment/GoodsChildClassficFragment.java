package net.school_a.app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import net.school_a.app.R;
import net.school_a.app.adapter.GoodsChildClassficListAdapter;
import net.school_a.app.model.bean.GoodsChildClassificDataModel;
import net.school_a.app.model.bean.GoodsClassificDataModel;
import net.school_a.app.widget.NoScrollListView;

import java.util.ArrayList;

/**
 * author：Anumbrella
 * Date：16/5/26 下午7:13
 */
public class GoodsChildClassficFragment extends Fragment {

    public ArrayList<GoodsChildClassificDataModel> goodsChildClassificDataModels;
    private GoodsClassificDataModel model;

    /**
     * widget网格view
     */
    private NoScrollListView listView;


    private GoodsChildClassficListAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_layout, null);
        listView = (NoScrollListView) view.findViewById(R.id.child_listview);
        model = (GoodsClassificDataModel) getArguments().getSerializable("model");
        //临时数据
        goodsChildClassificDataModels = model.getList();

        adapter = new GoodsChildClassficListAdapter(getActivity(), goodsChildClassificDataModels);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                /*GoodsChildClassificDataModel data = goodsChildClassificDataModels.get(position);
                Intent intent = new Intent();
                intent.putExtra(CategorizeDetailProductActivity.INTENT_PRODUCT_ITEM_INFO, data);
                intent.setClass(getContext(), CategorizeDetailProductActivity.class);
                startActivity(intent);*/
            }
        });
        return view;
    }
}
