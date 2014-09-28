package com.exercise.activity;

import com.exercise.androidExercise.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartUpActivity extends Activity {
	private Button mEnterBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_up);
		initUI();
	}

	private void initUI() {
		initNextBtn();
	}

	private void initNextBtn() {
		mEnterBtn = (Button) findViewById(R.id.enter_btn);
		mEnterBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						DispatcherActivity.class);
				startActivity(i);
			}
		});
	}

}
