/**
 * 
 */
package com.msunsoft.hssphone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.msunsoft.hssphone.MainActivity;
import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.base.BaseActivity;

/**
 * @author lili.guo
 *
 * 2014-8-21
 */
public class LoginActivity extends BaseActivity {
	
	private Button login_bt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		login_bt=(Button) findViewById(R.id.login_bt);
		
		login_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
	}

}
