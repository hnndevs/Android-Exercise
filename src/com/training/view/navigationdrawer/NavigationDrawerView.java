package com.training.view.navigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.training.R;
import com.training.view.AbstractView;

/**
 * Guide:
 * http://developer.android.com/training/implementing-navigation/nav-drawer.html
 */
public class NavigationDrawerView extends AbstractView {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private DrawerListAdapter mDrawerAdapter;
	private View mDrawerHeader;

	@Override
	protected int getViewLayoutId() {
		return R.layout.navigation_drawer_view;
	}

	@Override
	protected void initUI(View view) {
		initDrawerLayout(view);
		initDrawerList(view);
	}

	private void initDrawerLayout(View view) {
		mDrawerLayout = (DrawerLayout) view
				.findViewById(R.id.nav_drawer_layout);
	}

	private void initDrawerList(View view) {
		mDrawerList = (ListView) view.findViewById(R.id.nav_drawer_left);

		mDrawerHeader = mLayoutInflater.inflate(
				R.layout.navigation_drawer_header, null);
		mDrawerHeader.setClickable(false);
		mDrawerList.addHeaderView(mDrawerHeader);

		mDrawerAdapter = new DrawerListAdapter();
		mDrawerList.setAdapter(mDrawerAdapter);

		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mDrawerLayout.closeDrawers();
				showToast("Item " + position);
			}
		});
	}

	private class DrawerListAdapter extends BaseAdapter {

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public int getCount() {
			return 20;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			if (view == null) {
				// following the View Holder pattern - if the view is not null,
				// it should be recycled for smoother scrolling
				view = mLayoutInflater.inflate(R.layout.navigation_drawer_item,
						null);
			}
			TextView text = (TextView) view.findViewById(R.id.nav_drawer_text);
			text.setText(String.valueOf(position + 1));
			return view;
		}

	}

}
