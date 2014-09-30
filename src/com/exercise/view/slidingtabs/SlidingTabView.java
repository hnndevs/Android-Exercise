package com.exercise.view.slidingtabs;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exercise.androidExercise.R;
import com.exercise.view.AbstractView;
import com.exercise.view.slidingtabs.SlidingTabLayout.TabColorizer;

public class SlidingTabView extends AbstractView {
	private ViewPager mViewPager;
	private ViewPagerAdapter mPagerAdapter;
	private SlidingTabLayout mSlidingTabLayout;

	@Override
	protected int getViewLayoutId() {
		return R.layout.view_sliding_tab;
	}

	@Override
	protected void initUI(View view) {
		initViewPager(view);
		initSlidingTab(view);
	}

	private void initViewPager(View view) {
		mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
		mPagerAdapter = new ViewPagerAdapter();
		mViewPager.setAdapter(mPagerAdapter);
	}

	private void initSlidingTab(View view) {
		mSlidingTabLayout = (SlidingTabLayout) view
				.findViewById(R.id.sliding_tab);
		mSlidingTabLayout.setViewPager(mViewPager);
		TabColorizer colorizer = new TabColorizer() {

			@Override
			public int getIndicatorColor(int position) {
				return (position % 2 == 0) ? Color.BLACK : Color.GRAY;
			}

			@Override
			public int getDividerColor(int position) {
				return Color.GRAY;
			}
		};
		mSlidingTabLayout.setCustomTabColorizer(colorizer);
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
		public CharSequence getPageTitle(int position) {
			return "Page " + (position + 1);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			LayoutInflater inflater = LayoutInflater.from(getActivity());
			View page = inflater.inflate(R.layout.view_pager_item, null);
			TextView text = (TextView) page
					.findViewById(R.id.view_pager_item_tv);
			text.setText("Page " + (position + 1));
			container.addView(page);
			return page;
		}

	}

}
