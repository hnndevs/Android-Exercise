package com.training.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.training.R;
import com.training.view.dialog.BaseDialog;
import com.training.view.dialog.BaseDialog.OnDialogClickListener;

public class StartUpActivity extends FragmentActivity {
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

	@Override
	public void onBackPressed() {
		showExitDialog();
	}

	private void showExitDialog() {
		BaseDialog dialog = BaseDialog.createDialog(getApplicationContext(),
				R.string.exit, R.string.exit_confirmation, R.string.yes,
				R.string.cancel, new OnDialogClickListener() {

					@Override
					public void onPositiveButtonClicked() {
						finish();
					}

					@Override
					public void onNegativeButtonClicked() {
						// do nothing
					}
				});
		dialog.show(getSupportFragmentManager(), BaseDialog.TAG);
	}

}
