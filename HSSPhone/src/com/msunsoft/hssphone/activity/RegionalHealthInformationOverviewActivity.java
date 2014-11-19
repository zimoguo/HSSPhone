/**
 * 
 */
package com.msunsoft.hssphone.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.base.BaseActivity;

/**
 * 区域卫生信息概览
 * 
 * @author lili.guo
 * 
 *         2014-8-25
 */
public class RegionalHealthInformationOverviewActivity extends BaseActivity {

	private LinearLayout iv_home;
	private TextView tv_baseactivity_titlemiddle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BaseSetTitleView(R.layout.titlebar);
		BaseSetContentView(R.layout.activity_information_overview);

		iv_home = (LinearLayout) findViewById(R.id.iv_home);
		tv_baseactivity_titlemiddle = (TextView) findViewById(R.id.tv_baseactivity_titlemiddle);
		
		iv_home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		tv_baseactivity_titlemiddle.setText("区域卫生信息概览");
	}

}
