package com.msunsoft.hssphone.view;

import com.msunsoft.hssphone.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RadioButton extends LinearLayout {
	private Context context;
	private ImageView imageView;
	private TextView textView;

	private int index = 0;
	private int id = 0;// 判断是否选中

	private RadioButton tempRadioButton;// 模版用于保存上次点击的对象

	/***
	 * 改变图片
	 */
	public void SetImage(Drawable drawable) {

		if (drawable != null) {

			imageView.setBackgroundDrawable(drawable);
		}
	}

	/***
	 * 设置文本
	 * 
	 * @param text
	 */

	public void setText(String text) {
		textView.setText(text);
	}

	public void setTextColor(int color) {
		textView.setTextColor(color);
	}

	public String getText() {
		return id == 0 ? "" : textView.getText().toString();

	}

	public RadioButton(Context context) {
		this(context, null);

	}

	public RadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		LayoutInflater.from(context).inflate(R.layout.radiobutton_item, this,
				true);
		if (isInEditMode()) {
			return;
		}
		imageView = (ImageView) findViewById(R.id.iv_radio_item);
		textView = (TextView) findViewById(R.id.tv_radio_item);

	}

}
