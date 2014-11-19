/**
 * 
 */
package com.msunsoft.hssphone.activity;

import com.msunsoft.hssphone.MainActivity;
import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.base.BaseActivity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * 基本药物使用监管
 * @author lili.guo
 *
 * 2014-8-26
 */
public class EssentialDrugsActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_essential_drugs);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
