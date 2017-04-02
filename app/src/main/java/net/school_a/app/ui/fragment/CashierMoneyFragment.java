package net.school_a.app.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.school_a.app.R;
import net.school_a.app.ui.activity.TakeMoneyActivity;
import net.school_a.app.widget.MyKeyboard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mac on 2017/3/18.
 * 快速销售
 */

public class CashierMoneyFragment extends Fragment {
    @BindView(R.id.c_m_money)
    MyKeyboard ed_Money;

    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cashier_money, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.c_m_btn)
    void click() {
        // 收银记账界面
        startActivity(new Intent(getActivity(), TakeMoneyActivity.class));
    }
}
