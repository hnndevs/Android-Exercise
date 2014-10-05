package com.exercise.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.exercise.androidExercise.R;
import com.exercise.view.AbstractView;
import com.exercise.view.HomeView;

/**
 * This activity currently holds only a single fragment. Manipulating multiple
 * fragments is a heavy task and will be done later.
 */
public class DispatcherActivity extends FragmentActivity implements
		ActivityCallback {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dispatcher);
		createView();
	}

	private void createView() {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fragment_container, new HomeView());
		ft.commit();
		fm.executePendingTransactions();
	}

	private void createView(Class<? extends AbstractView> viewClass) {
		try {
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.setCustomAnimations(R.anim.slide_in_animation,
					R.anim.slide_out_animation, R.anim.slide_in_pop_animation,
					R.anim.slide_out_pop_animation);
			Fragment fragment = viewClass.newInstance();
			ft.replace(R.id.fragment_container, fragment);
			ft.addToBackStack(viewClass.getSimpleName());
			ft.commit();
			fm.executePendingTransactions();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onCallback(Class<? extends AbstractView> viewClass) {
		createView(viewClass);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
