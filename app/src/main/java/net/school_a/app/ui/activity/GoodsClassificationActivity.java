package net.school_a.app.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import net.school_a.app.DataProvider;
import net.school_a.app.R;
import net.school_a.app.adapter.GoodsChildClassficAdapter;
import net.school_a.app.config.Config;
import net.school_a.app.model.bean.GoodsClassificDataModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mac on 2017/3/13.
 * 商品分类
 */

public class GoodsClassificationActivity extends BaseThemeSettingActivity {
    @BindView(R.id.order_all_toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_title)
    TextView tv_Title;

    private LayoutInflater linflater;

    private View[] shopViews;

    //private String[] listMenus;
    // 父级列表
    private List<GoodsClassificDataModel> fatherList;

    private GoodsChildClassficAdapter goodsChildClassficAdapter;

    private TextView[] listMenuTextViews;

    private Bundle savedState;


    /**
     * 默认的ViewPager选中的项
     */
    private int currentItem = 0;

    @BindView(R.id.goods)
    ViewPager viewPager;

    @BindView(R.id.tools_scrollView)
    ScrollView tools_scrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_classic);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbar.setTitle("");
        tv_Title.setText("商品分类");
        setToolbar(toolbar);
        linflater = LayoutInflater.from(this);
        initTools();
        initViewPager();
    }

    /**
     * 建立toolbar
     *
     * @param toolbar
     */
    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initViewPager() {
        // 由于使用了支持包所以最终必须确保所有的导入包都是来自支持包
        goodsChildClassficAdapter = new GoodsChildClassficAdapter(getSupportFragmentManager(), fatherList);
        viewPager.setAdapter(goodsChildClassficAdapter);
        // 为ViewPager设置页面变化的监控
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (viewPager.getCurrentItem() != position) {
                viewPager.setCurrentItem(position);
            }
            // 通过ViewPager监听点击字体颜色和背景的改变
            if (currentItem != position) {
                changeTextColor(position);
                changeTextLocation(position);
            }
            currentItem = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {


        }
    };

    /**
     * 初始化左边目录
     */
    private void initTools() {
        fatherList = DataProvider.getGoodsClassficlist();
        shopViews = new View[Config.categorizeToolsImg.length];
        listMenuTextViews = new TextView[fatherList.size()];
        LinearLayout toolsLayout = (LinearLayout) findViewById(R.id.tools);
        for (int i = 0; i < fatherList.size(); i++) {
            View view = linflater.inflate(R.layout.itemview_categorize_listmenus, null);
            // 给每个View设定唯一标识
            view.setId(i);
            // 给每个view添加点击监控事件
            view.setOnClickListener(ListItemMenusClickListener);
            // 获取到左侧栏的的TextView的组件
            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(fatherList.get(i).getName());
            toolsLayout.addView(view);
            // 传入的是地址不是复制的值
            listMenuTextViews[i] = textView;
            shopViews[i] = view;
        }
        changeTextColor(0);
    }

    private void changeTextColor(int position) {
        for (int i = 0; i < fatherList.size(); i++) {
            if (position != i) {
                listMenuTextViews[i].setBackgroundColor(0x00000000);
                listMenuTextViews[i].setTextColor(0xFF000000);
            }
        }
        listMenuTextViews[position].setBackgroundColor(0xFFFFFFFF);
        listMenuTextViews[position].setTextColor(0xFFFF5D5E);
    }

    private void changeTextLocation(int clickPosition) {
        int y = (shopViews[clickPosition].getTop());
        // 如果滑动条可以滑动的情况下就把点击的视图移动到顶部
        tools_scrollView.smoothScrollTo(0, y);

    }

    View.OnClickListener ListItemMenusClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem(v.getId());
        }
    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private void restoreState() {
        if (savedState != null) {
            currentItem = savedState.getInt("index");
        }
    }

    private Bundle saveState() {
        Bundle state = new Bundle();
        state.putInt("index", currentItem);
        return state;
    }

}
