package net.school_a.app.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.school_a.app.ui.fragment.GoodsListContentFragment;

/**
 * author：Anumbrella
 * Date：16/5/26 下午7:08
 */
public class CategorizeGoodsAdapter extends FragmentStatePagerAdapter {


    private String[] list;

    public CategorizeGoodsAdapter(FragmentManager fm, String[] array) {
        super(fm);
        list = array;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new GoodsListContentFragment();
        Bundle bundle = new Bundle();
        // 把选中的index指针传入过去
        bundle.putInt("index", position);
        // 设定在fragment当中去
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.length;
    }
}
