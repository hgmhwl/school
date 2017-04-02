/* 
 * Copyright 2012 Share.Ltd  All rights reserved.
 * Share.Ltd PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * @Adapter.java - 2012-12-25 ����3:05:46 - rock
 */

package net.school_a.app.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/**
 * adapter基类
 * @author Admin
 *
 * @param <T>
 */
public abstract class Adapter<T> extends BaseAdapter {
	protected List<T> list;

	public List<T> getList() {
		return list;
	}

	protected Context context;

	protected abstract View ourView(int position, View convertView,
			ViewGroup parent);

	public Adapter(Context context, List<T> list) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position < list.size() ? list.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return ourView(position, convertView, parent);
	}

}
