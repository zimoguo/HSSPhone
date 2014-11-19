package com.msunsoft.hssphone;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.msunsoft.hssphone.Util.Util;
import com.msunsoft.hssphone.activity.LoginActivity;
import com.msunsoft.hssphone.base.BaseActivity;
import com.msunsoft.hssphone.fragment.DetailedIndicators;
import com.msunsoft.hssphone.fragment.DiseaseControl;
import com.msunsoft.hssphone.fragment.MainFragment;
import com.msunsoft.hssphone.view.RadioButton;

public class MainActivity extends BaseActivity implements OnClickListener{

	private Fragment fragment;
	private Fragment currentFragment;
	private FragmentManager fragmentManager = getSupportFragmentManager();
	private LinearLayout fm_main_content;
	private RadioGroup rg_basemain_menu;
	private RadioButton rb_profilequery;
	private RadioButton rb_newprofile;
	private RadioButton rb_mobilefollowup;
	private RadioButton rb_jobalerts;
	private TextView tv_baseactivity_titlemiddle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BaseSetTitleView(R.layout.titlebar);
		BaseSetContentView(R.layout.activity_main);

		LinearLayout iv_home = (LinearLayout) findViewById(R.id.iv_home);
		tv_baseactivity_titlemiddle= (TextView) findViewById(R.id.tv_baseactivity_titlemiddle);
		
		iv_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Builder dialog = new Builder(MainActivity.this);
				dialog.setTitle("提示：");
				dialog.setMessage("是否注销？");
				dialog.setCancelable(false);
				dialog.setPositiveButton("是",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								MainActivity.this.finish();
							}
						})
						.setNegativeButton("否",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(
											DialogInterface dialog,
											int which) {
										dialog.cancel();
									}
								}).show();
			}
		});
		
		if (Util.getAndroidSDKVersion()>=4) {
			if (null != currentFragment) {
				fragmentManager.beginTransaction().detach(currentFragment)
						.commit();
			}
			if (fragmentManager.findFragmentById(R.id.fm_main_content) == null){
				tv_baseactivity_titlemiddle.setText("首页");
				
				if (fragment == null) {
					fragment = new MainFragment();
					FragmentTransaction transaction = fragmentManager
							.beginTransaction();
					fragmentManager.popBackStack();
					transaction.add(R.id.fm_main_content, fragment)
							.attach(fragment).commit();
					fragmentManager.beginTransaction().attach(fragment)
							.commit();
					currentFragment = fragment;
				}
			}
		}

		fm_main_content = (LinearLayout) findViewById(R.id.fm_main_content);
		rg_basemain_menu = (RadioGroup) findViewById(R.id.rg_basemain_menu);
		rb_profilequery = (RadioButton) findViewById(R.id.rb_basemain_main);
		rb_newprofile = (RadioButton) findViewById(R.id.rb_basemain_detail);
		rb_mobilefollowup = (RadioButton) findViewById(R.id.rb_basemain_illcontrol);
		rb_jobalerts = (RadioButton) findViewById(R.id.rb_basemain_drugs);

		rb_profilequery.setText("首页");
		rb_newprofile.setText("详细指标");
		rb_mobilefollowup.setText("疾病控制");
		rb_jobalerts.setText("药品管理");
		
		rb_profilequery.setTextColor(getResources().getColor(R.color.text_color_blue));
		rb_newprofile.setTextColor(getResources().getColor(R.color.text_color_blue));
		rb_mobilefollowup.setTextColor(getResources().getColor(R.color.text_color_blue));
		rb_jobalerts.setTextColor(getResources().getColor(R.color.text_color_blue));

		rb_profilequery.SetImage(getResources().getDrawable(
				R.drawable.main));
		rb_newprofile.SetImage(getResources().getDrawable(
				R.drawable.detail));
		rb_mobilefollowup.SetImage(getResources().getDrawable(
				R.drawable.ill_control));
		rb_jobalerts.SetImage(getResources().getDrawable(
				R.drawable.drug_administration));

		rb_profilequery.setOnClickListener(this);
		rb_newprofile.setOnClickListener(this);
		rb_mobilefollowup.setOnClickListener(this);
		rb_jobalerts.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 首页
		case R.id.rb_basemain_main:
			//rb_profilequery.setTextColor(getResources().getColor(R.color.text_color_gray));
			fragment = new MainFragment();
			tv_baseactivity_titlemiddle.setText("首页");
			if (fragmentManager.findFragmentById(R.id.fm_main_content) != null) {
				FragmentTransaction transaction = fragmentManager
						.beginTransaction();
				fragmentManager.popBackStack();
				transaction.replace(R.id.fm_main_content, fragment).attach(
						fragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
			break;

		// 详细指标
		case R.id.rb_basemain_detail:
			//rb_newprofile.setTextColor(getResources().getColor(R.color.text_color_gray));
			fragment = new DetailedIndicators();
			tv_baseactivity_titlemiddle.setText("详细指标");
			if (fragmentManager.findFragmentById(R.id.fm_main_content) != null) {
				FragmentTransaction transaction = fragmentManager
						.beginTransaction();
				fragmentManager.popBackStack();
				transaction.replace(R.id.fm_main_content, fragment).attach(
						fragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
			break;

		// 疾病控制
		case R.id.rb_basemain_illcontrol:
			fragment = new DiseaseControl();
			tv_baseactivity_titlemiddle.setText("疾病控制");
			if (fragmentManager.findFragmentById(R.id.fm_main_content) != null) {
				FragmentTransaction transaction = fragmentManager
						.beginTransaction();
				fragmentManager.popBackStack();
				transaction.replace(R.id.fm_main_content, fragment).attach(
						fragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
			break;

		// 工作提醒
		case R.id.rb_basemain_drugs:

			break;
			
		default:
			break;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			Builder dialog = new Builder(MainActivity.this);
			dialog.setTitle("提示：");
			dialog.setMessage("是否注销？");
			dialog.setCancelable(false);
			dialog.setPositiveButton("是",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent();
							intent.setClass(getApplicationContext(),
									LoginActivity.class);
							startActivity(intent);
							MainActivity.this.finish();
						}
					})
					.setNegativeButton("否",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
								}
							}).show();
			return false;

		}
		return super.onKeyDown(keyCode, event);
	}

}
