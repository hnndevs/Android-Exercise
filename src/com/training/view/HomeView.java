package com.training.view;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.training.android.R;
import com.training.view.navigationdrawer.NavigationDrawerView;
import com.training.view.slidingtabs.SlidingTabView;

public class HomeView extends AbstractView {
	private ListView mListView;
	private ArrayAdapter<String> mAdapter;
	private HomeItemHolder mItemHolder;

	public HomeView() {
		mItemHolder = new HomeItemHolder();
		mItemHolder.addItem("Navigation Drawer", NavigationDrawerView.class);
		mItemHolder.addItem("Sliding Tabs", SlidingTabView.class);
	}

	@Override
	protected int getViewLayoutId() {
		return R.layout.home_view;
	}

	@Override
	protected void initUI(View view) {
		mListView = (ListView) view.findViewById(R.id.list_view);
		String[] items = mItemHolder.getNames();
		mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.home_item,
				items);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				HomeView.this.onItemClick(position);
			}

		});
	}

	private void onItemClick(int position) {
		Class<? extends AbstractView> clazz = mItemHolder.getView(position);
		openView(clazz);
	}

	private class HomeItemHolder {
		private List<String> names;
		private List<Class<? extends AbstractView>> views;

		public HomeItemHolder() {
			names = new ArrayList<String>();
			views = new ArrayList<Class<? extends AbstractView>>();
		}

		private void addItem(String name, Class<? extends AbstractView> clazz) {
			int index = names.size() + 1;
			names.add(index + ". " + name);
			views.add(clazz);
		}

		private String[] getNames() {
			String[] items = new String[names.size()];
			names.toArray(items);
			return items;
		}

		private Class<? extends AbstractView> getView(int location) {
			return views.get(location);
		}
	}

}
