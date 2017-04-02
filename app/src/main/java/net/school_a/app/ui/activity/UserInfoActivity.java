package net.school_a.app.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.umeng.message.PushAgent;

import net.school_a.app.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author：Anumbrella
 * Date：16/5/24 下午7:02
 * 个人中心
 */
public class UserInfoActivity extends BaseThemeSettingActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        PushAgent.getInstance(this).onAppStart();
    }

    @OnClick({R.id.btn_back})
    public void clickBtn(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
