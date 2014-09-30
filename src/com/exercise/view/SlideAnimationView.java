package com.exercise.view;

import com.exercise.androidExercise.R;
import com.exercise.view.slidingtabs.SlidingTabView;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SlideAnimationView extends AbstractView {
	private Button mNextBtn;

	@Override
	protected int getViewLayoutId() {
		return R.layout.view_slide_animation;
	}

	@Override
	protected void initUI(View view) {
		initReplaceBtn(view);
	}

	private void initReplaceBtn(View view) {
		mNextBtn = (Button) view.findViewById(R.id.next_btn);
		mNextBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				openView(SlidingTabView.class);
			};
		});
	}

}
