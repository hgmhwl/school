package net.school_a.app.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.umeng.message.PushAgent;

import net.school_a.app.R;
import net.school_a.app.model.bean.SupplierDatamodel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mac on 2017/3/11.
 * 供应商详情
 */

public class SupplierDetailActivity extends BaseThemeSettingActivity {
    @BindView(R.id.order_all_toolbar)
    Toolbar toolbar;
    private SupplierDatamodel datamodel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_detail);
        ButterKnife.bind(this);
        PushAgent.getInstance(this).onAppStart();
        initView();
    }

    private void initView() {
        datamodel = (SupplierDatamodel) getIntent().getExtras().getSerializable("model");
        Toast.makeText(this, "" + datamodel.getName(), Toast.LENGTH_LONG).show();
        toolbar.setTitle("");
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
}
