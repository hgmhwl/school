package net.school_a.app.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.swipe.SwipeRefreshLayout;
import com.jude.rollviewpager.RollPagerView;
import com.jude.utils.JFileManager;

import net.school_a.app.R;
import net.school_a.app.adapter.ImageLoopAdapter;
import net.school_a.app.app.App;
import net.school_a.app.model.bean.BannerDataModel;
import net.school_a.app.widget.BannerTextHintView;

import java.util.List;

/**
 * author：Anumbrella
 * Date：16/5/25 下午10:39
 */
public class RollViewPagerItemView implements RecyclerArrayAdapter.ItemView {

    RollPagerView rollPagerView;

    ImageLoopAdapter adapter;

    SwipeRefreshLayout swipeRefreshLayout;

    Context context;

    private static List<BannerDataModel> banners;

    JFileManager.Folder folder;

    public RollViewPagerItemView(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }


    @Override
    public View onCreateView(ViewGroup parent) {
        context = parent.getContext();
        folder = JFileManager.getInstance().getFolder(App.Dir.Object);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_rollviewpager, parent, false);
        rollPagerView = (RollPagerView) view.findViewById(R.id.roll_view_pager);
        //解决viewPager和swipeRefreshLayout的冲突
        rollPagerView.getViewPager().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_MOVE:
                        swipeRefreshLayout.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        swipeRefreshLayout.setEnabled(true);
                        break;
                }
                return false;
            }
        });
        setData();
        return view;
    }

    private void setData() {
        //加载缓存数据
        getBannerFromCache();
        //延迟加载，和缓存加载间隔一段时间，避免卡顿
    }

    private void getBannerFromCache() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                banners = (List<BannerDataModel>) folder.readObjectFromFile("banner");
                if (banners != null && banners.size() != 0) {
                    rollPagerView.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter = new ImageLoopAdapter();
                            adapter.setBannerDataModels(banners);
                            rollPagerView.setHintView(new BannerTextHintView(context, banners));
                            rollPagerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        }).start();

    }

    @Override
    public void onBindView(View headerView) {
    }
}
