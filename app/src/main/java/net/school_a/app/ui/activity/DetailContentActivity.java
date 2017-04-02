package net.school_a.app.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.umeng.message.PushAgent;

import net.school_a.app.R;
import net.school_a.app.model.bean.ListProductContentModel;
import net.school_a.app.model.bean.RecommendContentModel;
import net.school_a.app.ui.fragment.DetailContentFragment;

/**
 * author：Anumbrella
 * Date：16/5/25 下午10:17
 */
public class DetailContentActivity extends BaseThemeSettingActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailcontent);
        PushAgent.getInstance(this).onAppStart();
        DetailContentFragment fragment = null;
        if (getIntent().getParcelableExtra(DetailContentFragment.ARG_ITEM_INFO_RECOMMEND) instanceof RecommendContentModel) {
            fragment = DetailContentFragment.newInstance((RecommendContentModel) getIntent().getParcelableExtra(DetailContentFragment.ARG_ITEM_INFO_RECOMMEND));
        } else if(getIntent().getParcelableExtra(DetailContentFragment.ARG_ITEM_INFO_LISTPRODUCT) instanceof ListProductContentModel){
            fragment = DetailContentFragment.newInstance((ListProductContentModel) getIntent().getParcelableExtra(DetailContentFragment.ARG_ITEM_INFO_LISTPRODUCT));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
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
