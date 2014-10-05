package com.exercise.activity;

import com.exercise.view.AbstractView;

/**
 * An interface for communication between Activities and Fragments.
 */
public interface ActivityCallback {

	void onCallback(Class<? extends AbstractView> viewClass);

}
