package com.example.firstapp;

import android.app.Activity;
import android.os.Bundle;

public class HelloWorldActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.right_to_left_animation, R.anim.left_to_right_animation);
	}
}
