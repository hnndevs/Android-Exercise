package com.exercise.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.exercise.activity.ActivityCallback;
import com.exercise.androidExercise.R;

/**
 * An abstract class which contains common logic for all views in this project.
 */
public abstract class AbstractView extends Fragment {

	/** Provides communication between the Fragment and it's holder Activity. */
	protected ActivityCallback mCallback;

	/**
	 * This is the root of the view hierarchy, which is a {@link ViewGroup}. In
	 * our case it is the top RelativeLayout in the XML.
	 */
	protected ViewGroup mViewRoot;

	/**
	 * For a given layout id {@link #getViewLayoutId()}, the layout is inflated
	 * into this container.
	 */
	protected ViewGroup mViewContainer;

	/** Inflater is used to build a View object from a given XML file. */
	protected LayoutInflater mLayoutInflater;

	/** Pass the view layout id. */
	protected abstract int getViewLayoutId();

	/** Initialize the user interface. */
	protected abstract void initUI(View view);

	/** A flag to determine if the view container is vertically scrollable. */
	protected boolean isViewScrollable() {
		return false;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mCallback = (ActivityCallback) activity;
		this.mLayoutInflater = activity.getLayoutInflater();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mViewRoot = initViewLayout();
		initViewContainer(mViewRoot, inflater);
		initUI(mViewRoot);
		return mViewRoot;
	}

	private ViewGroup initViewLayout() {
		int layoutId = isViewScrollable() ? R.layout.abstract_scrollable_view
				: R.layout.abstract_view;
		mViewRoot = (ViewGroup) mLayoutInflater.inflate(layoutId, null);
		return mViewRoot;
	}

	private void initViewContainer(View view, LayoutInflater inflater) {
		mViewContainer = (ViewGroup) view.findViewById(R.id.view_container);
		int layoutId = getViewLayoutId();
		if (layoutId != 0) {
			inflater.inflate(layoutId, mViewContainer, true);
		}
	}

	protected void openView(Class<? extends AbstractView> viewClass) {
		this.mCallback.onCallback(viewClass);
	}

	protected void showToast(String message) {
		Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
	}

}
