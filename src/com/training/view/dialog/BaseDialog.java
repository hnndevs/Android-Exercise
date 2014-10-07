package com.training.view.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.WindowManager.LayoutParams;

import com.training.R;

/**
 * Guide: http://developer.android.com/guide/topics/ui/dialogs.html
 */
public class BaseDialog extends DialogFragment {
	public static final String TAG = BaseDialog.class.getSimpleName();

	public static final int BUTTON_POSITIVE = DialogInterface.BUTTON_POSITIVE;
	public static final int BUTTON_NEGATIVE = DialogInterface.BUTTON_NEGATIVE;
	public static final int BUTTON_NEUTRAL = DialogInterface.BUTTON_NEUTRAL;

	private static final String KEY_TITLE = "TITLE";
	private static final String KEY_MESSAGE = "MESSAGE";
	private static final String KEY_POSITIVE_BUTTON_TEXT = "POSITIVE_BUTTON_TEXT";
	private static final String KEY_NEGATIVE_BUTTON_TEXT = "NEGATIVE_BUTTON_TEXT";

	private OnDialogClickListener mDialogListener;

	private OnClickListener mListener = new OnClickListener() {

		@Override
		public void onClick(DialogInterface dialog, int button) {
			switch (button) {
			case BUTTON_POSITIVE:
				mDialogListener.onPositiveButtonClicked();
				break;
			case BUTTON_NEGATIVE:
				mDialogListener.onNegativeButtonClicked();
				break;
			default:
				break;
			}
		}
	};

	public static BaseDialog createDialog(Context ctx, int titleId,
			int messageId, int positiveButtonTextId, int negativeButtonTextId,
			OnDialogClickListener listener) {
		String title = ctx.getString(titleId);
		String message = ctx.getString(messageId);
		String positiveButtonText = ctx.getString(positiveButtonTextId);
		String negativeButtonText = ctx.getString(negativeButtonTextId);
		BaseDialog dialog = new BaseDialog(title, message, positiveButtonText,
				negativeButtonText, listener);
		return dialog;
	}

	private BaseDialog(String title, String message, String positiveButtonText,
			String negativeButtonText, OnDialogClickListener listener) {
		Bundle args = new Bundle();
		args.putString(KEY_TITLE, title);
		args.putString(KEY_MESSAGE, message);
		args.putString(KEY_POSITIVE_BUTTON_TEXT, positiveButtonText);
		args.putString(KEY_NEGATIVE_BUTTON_TEXT, negativeButtonText);
		// every Fragment has a Bundle used to transfer data
		setArguments(args);

		this.mDialogListener = listener;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		Bundle args = getArguments();

		String title = args.getString(KEY_TITLE);
		builder.setTitle(title);

		String message = args.getString(KEY_MESSAGE);
		builder.setMessage(message);

		String positiveButtonText = args.getString(KEY_POSITIVE_BUTTON_TEXT);
		builder.setPositiveButton(positiveButtonText, mListener);

		String negativeButtonText = args.getString(KEY_NEGATIVE_BUTTON_TEXT);
		builder.setNegativeButton(negativeButtonText, mListener);

		AlertDialog dialog = builder.create();
		LayoutParams attributes = dialog.getWindow().getAttributes();
		attributes.windowAnimations = R.style.DialogAnimation;
		return dialog;
	}

	public interface OnDialogClickListener {
		void onPositiveButtonClicked();

		void onNegativeButtonClicked();
	}

}
