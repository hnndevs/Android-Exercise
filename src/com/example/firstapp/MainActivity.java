package com.example.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button lala;
	private Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lala = (Button) findViewById(R.id.button);
		button2 = (Button) findViewById(R.id.button2);
		lalaAction();
	}

	private void lalaAction() {
		lala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Intent i = new Intent(getApplicationContext(),
				// HelloWorldActivity.class);
				// startActivity(i);

				if (button2.getVisibility() == View.VISIBLE) {
					button2.setVisibility(View.INVISIBLE);
				} else {
					button2.setVisibility(View.VISIBLE);
					button2.setClickable(false);
				}
			}
		});
	}
}
