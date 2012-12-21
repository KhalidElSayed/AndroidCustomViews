package com.michaelpardo.androidcustomviews.widget;

import com.michaelpardo.androidcustomviews.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TitledTextView extends LinearLayout {
	private TextView mTitleTextView;
	private TextView mTextTextView;

	public TitledTextView(Context context) {
		this(context, null);
	}

	public TitledTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		setOrientation(VERTICAL);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitledTextView);
		String title = a.getString(R.styleable.TitledTextView_android_title);
		String text = a.getString(R.styleable.TitledTextView_android_text);

		a.recycle();

		mTitleTextView = new TextView(context);
		mTitleTextView.setText(title);
		mTitleTextView.setTypeface(Typeface.DEFAULT_BOLD);
		addView(mTitleTextView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		mTextTextView = new TextView(context);
		mTextTextView.setText(text);
		addView(mTextTextView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	}

	public void setTitle(String title) {
		mTitleTextView.setText(title);
	}

	public void setText(String text) {
		mTextTextView.setText(text);
	}
}