package com.exercise.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exercise.androidExercise.R;

public class ViewPagerView extends AbstractView {
	private ViewPager mViewPager;
	private ViewPagerAdapter mPagerAdapter;

	@Override
	protected int getViewLayoutId() {
		return R.layout.view_pager;
	}

	@Override
	protected void initUI(View view) {
		initViewPager(view);
	}

	private void initViewPager(View view) {
		mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
		mPagerAdapter = new ViewPagerAdapter();
		mViewPager.setAdapter(mPagerAdapter);
	}

	private class ViewPagerAdapter extends PagerAdapter {
		private static final int NUM_PAGES = 5;

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public int getCount() {
			return NUM_PAGES;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object page) {
			container.removeView((View) page);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			LayoutInflater inflater = LayoutInflater.from(getActivity());
			View page = inflater.inflate(R.layout.view_pager_item, null);
			TextView text = (TextView) page
					.findViewById(R.id.view_pager_item_tv);
			position += 1;
			text.setText("Page " + position);
			container.addView(page);
			return page;
		}

	}

}
