package net.school_a.app.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.school_a.app.model.bean.GoodsClassificDataModel;
import net.school_a.app.ui.fragment.GoodsChildClassficFragment;

import java.util.List;

/**
 * author：Anumbrella
 * Date：16/5/26 下午7:08
 */
public class GoodsChildClassficAdapter extends FragmentStatePagerAdapter {


    private List<GoodsClassificDataModel> list;

    public GoodsChildClassficAdapter(FragmentManager fm, List<GoodsClassificDataModel> array) {
        super(fm);
        list = array;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new GoodsChildClassficFragment();
        Bundle bundle = new Bundle();
        // 把选中的index指针传入过去
        bundle.putSerializable("model", list.get(position));
        // 设定在fragment当中去
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
