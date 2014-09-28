package com.exercise.activity;

import com.exercise.view.AbstractView;

/**
 * Provides communication between Activities and Fragments.
 */
public interface ActivityCallback {

	void onCallback(Class<? extends AbstractView> viewClass);

}
