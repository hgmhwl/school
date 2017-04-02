package net.school_a.app.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.gxz.PagerSlidingTabStrip;

import net.school_a.app.R;
import net.school_a.app.adapter.ItemTitlePagerAdapter;
import net.school_a.app.ui.fragment.CashierGoodsFragment;
import net.school_a.app.ui.fragment.CashierMoneyFragment;
import net.school_a.app.ui.fragment.CashierScanFragment;
import net.school_a.app.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mac on 2017/3/18.
 * 收银记账
 */

public class CashierActivity extends BaseThemeSettingActivity {
    @BindView(R.id.order_all_toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_title)
    TextView tv_Title;

    public PagerSlidingTabStrip psts_tabs;
    public NoScrollViewPager vp_content;
    private List<Fragment> fragmentList = new ArrayList<>();
    private CashierGoodsFragment cashierGoodsFragment;
    private CashierMoneyFragment cashierMoneyFragment;
    private CashierScanFragment cashierScanFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbar.setTitle("");
        tv_Title.setText("收银记账");
        setToolbar(toolbar);
        makeView();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void makeView() {
        psts_tabs = (PagerSlidingTabStrip) findViewById(R.id.psts_tabs);
        vp_content = (NoScrollViewPager) findViewById(R.id.vp_content);
        cashierGoodsFragment = new CashierGoodsFragment();
        cashierMoneyFragment = new CashierMoneyFragment();
        cashierScanFragment = new CashierScanFragment();
        fragmentList.add(cashierMoneyFragment);
        fragmentList.add(cashierGoodsFragment);
        fragmentList.add(cashierScanFragment);
        vp_content.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                fragmentList, new String[]{"快速销售", "商品销售", "扫码销售"}));
        vp_content.setOffscreenPageLimit(3);
        psts_tabs.setViewPager(vp_content);
    }
}
