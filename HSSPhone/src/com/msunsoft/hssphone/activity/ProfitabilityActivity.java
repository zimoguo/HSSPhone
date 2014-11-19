/**
 * 
 */
package com.msunsoft.hssphone.activity;

import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.base.BaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * 收益能力
 * @author lili.guo
 *
 * 2014-8-26
 */
public class ProfitabilityActivity extends BaseActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profitability);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
