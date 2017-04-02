package net.school_a.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

import net.school_a.app.R;
import net.school_a.app.adapter.IndexGridAdapter;
import net.school_a.app.ui.activity.AddGoodsActivity;
import net.school_a.app.ui.activity.AddVipActivity;
import net.school_a.app.ui.activity.CashierActivity;
import net.school_a.app.ui.activity.GoodsManagerActivity;
import net.school_a.app.ui.activity.SupplierManagerActivity;
import net.school_a.app.ui.activity.VipManagerActivity;
import net.school_a.app.ui.viewholder.NetworkImageHolderView;
import net.school_a.app.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * author：Anumbrella
 * Date：16/5/24 下午8:04
 */
public class IndexFragment extends Fragment {
    private LayoutInflater linflater;
    @BindView(R.id.vp_item_goods_img)
    ConvenientBanner vp_item_goods_img;
    @BindView(R.id.gridview)
    MyGridView gridView;
    private Intent intent;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newindex, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        linflater = LayoutInflater.from(getContext());
        init();
        return view;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // 开始自动翻页
    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        vp_item_goods_img.startTurning(4000);
    }

    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        vp_item_goods_img.stopTurning();
    }

    private void init() {
        gridView.setAdapter(new IndexGridAdapter(getActivity()));
        //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
        vp_item_goods_img.setPageIndicator(new int[]{R.mipmap.index_white, R.mipmap.index_red});
        vp_item_goods_img.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        List<String> imgs = new ArrayList<>();
        imgs.add("http://yp.dajinw.com/data/upload/shop/editor/web-101-102-2-1.jpg?718");
        imgs.add("http://yp.dajinw.com/data/upload/shop/editor/web-101-102-2-2.jpg?967");
        imgs.add("http://yp.dajinw.com/data/upload/shop/editor/web-101-102-2-3.jpg?477");
        imgs.add("http://yp.dajinw.com/data/upload/shop/editor/web-101-102-2-4.jpg?643");
        setLoopView(imgs);
    }

    public void setLoopView(List<String> list) {
        List<String> imgUrls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            imgUrls.add(list.get(i));
        }
        //初始化商品图片轮播
        vp_item_goods_img.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NetworkImageHolderView();
            }
        }, imgUrls);
    }

    @OnItemClick(R.id.gridview)
    void gridClick(int position) {
        switch (position) {
            case 0:
                // 新增商品
                startActivity(new Intent(getActivity(), AddGoodsActivity.class));
                break;
            case 1:
                // 新增会员
                startActivity(new Intent(getActivity(), AddVipActivity.class));
                break;
            case 2:
                // 收银记账
                startActivity(new Intent(getActivity(), CashierActivity.class));
                break;
            case 3:
                // 支出管理
                break;
            case 4:
                // 商品管理
                startActivity(new Intent(getActivity(), GoodsManagerActivity.class));
                break;
            case 5:
                // 会员管理
                startActivity(new Intent(getActivity(), VipManagerActivity.class));
                break;
            case 6:
                // 查询销售
                break;
            case 7:
                // 智能分析
                break;
            case 8:
                // 供应商管理
                startActivity(new Intent(getActivity(), SupplierManagerActivity.class));
                break;
            case 9:
                // 挂单
                break;
            case 10:
                // 手机橱窗
                break;
            case 11:
                // 发短信
                break;
            default:
                break;
        }
    }
}
