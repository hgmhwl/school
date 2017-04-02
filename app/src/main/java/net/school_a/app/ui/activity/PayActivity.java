package net.school_a.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import net.school_a.app.R;
import net.school_a.app.utils.CodeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mac on 2017/3/22.
 * 支付确认
 */

public class PayActivity extends BaseThemeSettingActivity {
    @BindView(R.id.order_all_toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_title)
    TextView tv_Title;
    @BindView(R.id.pay_code_img)
    ImageView iv_Code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbar.setTitle("");
        tv_Title.setText("微信收款");
        iv_Code.setImageBitmap(CodeUtil.createQRImage("http://www.baidu.cn"));
        setToolbar(toolbar);
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

    @OnClick(R.id.pay_scan_btn)
    void sacn() {
        // 扫一扫收款
        /*Intent intent = new Intent(this,
                CaptureActivity.class);
        startActivityForResult(intent, 100);*/
        startActivity(new Intent(this, ScanPayActivity.class));
    }

    /*@Override
    public void onActivityResult(int arg0, int arg1, Intent data) {
        super.onActivityResult(arg0, arg1, data);
        *//**
     * 拿到解析完成的字符串
     *//*
        if (data != null) {
            String result = data.getStringExtra("result");
            // 跳转到支付结果界面
            startActivity(new Intent(this, PayResultActivity.class));
        } else {
            Toast.makeText(getApplicationContext(), "扫描失败", Toast.LENGTH_SHORT).show();
        }
    }*/
}
