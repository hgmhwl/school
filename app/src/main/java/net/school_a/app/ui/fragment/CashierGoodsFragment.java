package net.school_a.app.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.school_a.app.R;
import net.school_a.app.animutils.GoodsAnimUtil;
import net.school_a.app.datasave.DemoData;
import net.school_a.app.datasave.GoodsDataBaseInterface;
import net.school_a.app.datasave.OperateGoodsDataBase;
import net.school_a.app.recycler.DividerItemDecoration;
import net.school_a.app.recycler.RecyclerViewContentAdapter;
import net.school_a.app.recycler.RecyclerViewMenuAdapter;
import net.school_a.app.ui.activity.PayListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mac on 2017/3/18.
 * 商品收银
 */

public class CashierGoodsFragment extends Fragment {
    /**
     * 标题
     */
    /**
     * 侧边栏菜单RecyclerView
     */
    @BindView(R.id.m_list_menu)
    RecyclerView mRecyclerMenu;
    /**
     * 内容RecyclerView
     */
    @BindView(R.id.m_list_content)
    RecyclerView mRecyclerContent;
    /**
     * 商品总价
     */
    @BindView(R.id.m_list_all_price)
    TextView mListAllPrice;
    /**
     * 物品总数量
     */
    @BindView(R.id.m_list_num)
    TextView mListAllNum;
    /**
     * 侧边栏菜单数据填充器
     */
    private RecyclerViewMenuAdapter mRecyclerViewMenuCommonadapter = null;
    /**
     * 内容数据填充器
     */
    private RecyclerViewContentAdapter mRecyclerViewContentCommonadapter = null;
    private Context mContext;
    /**
     * 存储数据list
     */
    private List<String> stringMenuList = new ArrayList<String>();
    private List<String> stringContentList = new ArrayList<String>();
    public static int SELECTPOSITION = 0;
    /**
     * 数据操作接口
     */
    GoodsDataBaseInterface mGoodsDataBaseInterface = null;
    /**
     * 购物车布局
     */
    @BindView(R.id.m_list_car_lay)
    RelativeLayout mCarLay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cashier_goods, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        mContext = getContext();
        initView();
        setRecyclerView();
        initHttp();
        return view;
    }

    private void initView() {
        mGoodsDataBaseInterface = OperateGoodsDataBase.getInstance();
        //清空数据库缓存
        mGoodsDataBaseInterface.deleteAll(mContext);
    }

    /**
     * 模拟网络请求数据
     */
    private void initHttp() {
        for (int i = 0; i < 10; i++) {
            stringMenuList.add("1111");
        }
        for (int i = 0; i < 4; i++) {
            stringContentList.add("2222");
        }
        setMenuCommonadapter();
        setContentCommonadapter();
    }

    @OnClick({R.id.m_list_submit})
    void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.m_fml_title_back:
                getActivity().finish();
                break;*/
            case R.id.m_list_submit:
                startActivity(new Intent(getActivity(), PayListActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * 设置RecyclerView的布局方式
     */
    private void setRecyclerView() {
        //垂直listview显示方式
        mRecyclerMenu.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerMenu.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        mRecyclerContent.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
    }

    /**
     * 菜单列表    数据填充
     */
    private void setMenuCommonadapter() {
        mRecyclerViewMenuCommonadapter = new RecyclerViewMenuAdapter(mContext, stringMenuList);
        mRecyclerMenu.setAdapter(mRecyclerViewMenuCommonadapter);
        mRecyclerViewMenuCommonadapter.setOnItemClickListener(new RecyclerViewMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                SELECTPOSITION = position;
                mRecyclerViewMenuCommonadapter.notifyDataSetChanged();
                mRecyclerViewContentCommonadapter.notifyDataSetChanged();
                setAll();
            }

            @Override
            public void onItemLongClick(View v, int position) {
            }
        });
    }

    /**
     * 商品种类列表    数据填充
     */
    private void setContentCommonadapter() {
        mRecyclerViewContentCommonadapter = new RecyclerViewContentAdapter(mContext, stringContentList);
        mRecyclerContent.setAdapter(mRecyclerViewContentCommonadapter);
        mRecyclerViewContentCommonadapter.setOnItemClickListener(new RecyclerViewContentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerViewContentAdapter.ViewHolder holder) {
            }

            @Override
            public void onItemLongClick(RecyclerViewContentAdapter.ViewHolder holder) {
            }

            /** 添加 */
            @Override
            public void onItemJiaClick(RecyclerViewContentAdapter.ViewHolder holder) {
                String numText = holder.mNumber.getText().toString().trim();
                /** 点击加号之前还没有数据的时候 */
                if (numText.isEmpty() || numText.equals("0")) {
                    holder.mImgJian.setVisibility(View.VISIBLE);
                    holder.mNumber.setText(mGoodsDataBaseInterface.saveGoodsNumber(mContext, SELECTPOSITION, DemoData.ListMenu_GOODSID[holder.getPosition()], "1", DemoData.ListMenu_PPRICE[holder.getPosition()]) + "");
                    holder.mNumber.setVisibility(View.VISIBLE);
                }/** 点击加号之前有数据的时候 */
                else {
                    holder.mNumber.setText(mGoodsDataBaseInterface.saveGoodsNumber(mContext, SELECTPOSITION, DemoData.ListMenu_GOODSID[holder.getPosition()], String.valueOf(Integer.parseInt(numText) + 1), DemoData.ListMenu_PPRICE[holder.getPosition()]) + "");
                }
                /** 动画 */
                GoodsAnimUtil.setAnim(getActivity(), holder.mImgJia, mCarLay);
                GoodsAnimUtil.setOnEndAnimListener(new onEndAnim());
                /** 统计购物总数和购物总价 */
            }

            /** 减少 */
            @Override
            public void onItemJianClick(RecyclerViewContentAdapter.ViewHolder holder) {
                String numText = holder.mNumber.getText().toString().trim();
                holder.mNumber.setText(mGoodsDataBaseInterface.saveGoodsNumber(mContext, SELECTPOSITION, DemoData.ListMenu_GOODSID[holder.getPosition()], String.valueOf(Integer.parseInt(numText) - 1), DemoData.ListMenu_PPRICE[holder.getPosition()]) + "");
                numText = holder.mNumber.getText().toString().trim();
                /** 减完之后  数据为0 */
                if (numText.equals("0")) {
                    holder.mNumber.setVisibility(View.GONE);
                    holder.mImgJian.setVisibility(View.GONE);
                }
                setAll();
            }
        });
    }

    /**
     * 动画结束后，更新所有数量和所有价格
     */
    class onEndAnim implements GoodsAnimUtil.OnEndAnimListener {
        @Override
        public void onEndAnim() {
            setAll();
        }
    }

    /**
     * 点击加号和减号的时候设置总数和总价格
     */
    private void setAll() {
        //设置所有购物数量
        if (mGoodsDataBaseInterface.getSecondGoodsNumberAll(mContext, SELECTPOSITION) == 0) {
            mListAllNum.setVisibility(View.GONE);
            mListAllPrice.setText("￥0");
            mListAllNum.setText("0");
        } else {
            mListAllPrice.setText("￥" + mGoodsDataBaseInterface.getSecondGoodsPriceAll(mContext, SELECTPOSITION) + "");
            mListAllNum.setText(mGoodsDataBaseInterface.getSecondGoodsNumberAll(mContext, SELECTPOSITION) + "");
            mListAllNum.setVisibility(View.VISIBLE);
        }
    }

}
