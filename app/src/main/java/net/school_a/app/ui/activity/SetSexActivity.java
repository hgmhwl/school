package net.school_a.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.TextView;

import net.school_a.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mac on 2017/3/17.
 * 设置性别
 */

public class SetSexActivity extends BaseThemeSettingActivity {

    @BindView(R.id.order_all_toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_title)
    TextView tv_Title;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    private String sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_sex);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbar.setTitle("");
        tv_Title.setText("性别");
        setToolbar(toolbar);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.set_sex_man:
                        sex = "男";
                        break;
                    case R.id.set_sex_woman:
                        sex = "女";
                        break;
                    case R.id.set_sex_none:
                        sex = "保密";
                        break;
                    default:
                        break;
                }
                Intent intent = new Intent();
                intent.setClass(SetSexActivity.this, AddVipActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("sex", sex);
                intent.putExtras(bundle);
                setResult(900, intent);
                finish();
            }
        });
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
}
