package com.exercise.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.exercise.activity.ActivityCallback;
import com.exercise.androidExercise.R;

public abstract class AbstractView extends Fragment {

	/** Provides communication between the Fragment and it's holder Activity. */
	protected ActivityCallback mCallback;

	/**
	 * This is the root of the view hierarchy, which is a {@link ViewGroup}. In
	 * our case it is the top RelativeLayout in the XML.
	 */
	protected ViewGroup mViewRoot;

	/**
	 * By passing a {@link #getViewLayoutId()}, the layout is inflated into this
	 * container.
	 */
	protected RelativeLayout mViewContainer;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mCallback = (ActivityCallback) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mViewRoot = (ViewGroup) inflater.inflate(R.layout.view_abstract, null);
		initViewContainer(mViewRoot, inflater);
		initUI(mViewRoot);
		return mViewRoot;
	}

	private void initViewContainer(View view, LayoutInflater inflater) {
		mViewContainer = (RelativeLayout) view
				.findViewById(R.id.view_container);
		int layoutId = getViewLayoutId();
		if (layoutId != 0) {
			inflater.inflate(layoutId, mViewContainer, true);
		}
	}

	protected abstract int getViewLayoutId();

	protected abstract void initUI(View view);

	protected void openView(Class<? extends AbstractView> viewClass) {
		this.mCallback.onCallback(viewClass);
	}

}
