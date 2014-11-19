package com.msunsoft.hssphone.base;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.Util.Util;

public abstract class BaseActivity extends FragmentActivity {

	// 声明分配布局的layoutID,如果分配的是RelativeLayout,也可以，根据自己需求来换

	// protected CustomProgressDialog progressDialog;

	private LinearLayout llcontent;

	private static final int ACTIVITY_RESUME = 0;

	private static final int ACTIVITY_STOP = 1;

	private static final int ACTIVITY_PAUSE = 2;

	private static final int ACTIVITY_DESTROY = 3;

	public int activityState;

	private TextView tv_title_right;
	private LinearLayout ll_content_title;

	protected ActionBar actionBar;
	private int heigh;

	protected Gson gson;
	protected Dialog dialog;
	// 是否允许全屏
	private boolean mAllowFullScreen = true;

	public void setAllowFullScreen(boolean allowFullScreen) {
		this.mAllowFullScreen = allowFullScreen;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WindowManager wm = (WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE);
		heigh = wm.getDefaultDisplay().getHeight();
		Log.i("create>>", this.getClass() + "oncreate...............");
		// 竖屏锁定
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		if (mAllowFullScreen) {

			requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题

		}
		setContentView(R.layout.base);// 基础的布局
		gson = new Gson();
		dialog = Util.createLoadingDialog(this, " ");
		

		AppManager.getAppManager().addActivity(this);

	}
	

	@Override
	protected void onStart() {
		super.onStart();
		dialog = Util.createLoadingDialog(this, " ");

	}

	@Override
	protected void onResume() {
		super.onResume();
		activityState = ACTIVITY_RESUME;
		dialog = Util.createLoadingDialog(this, " ");
	}

	@Override
	protected void onStop() {
		super.onStop();
		activityState = ACTIVITY_STOP;
		Log.i("stop>>" + this.getClass(), "---------onStop ");
	}

	@Override
	protected void onPause() {
		super.onPause();
		activityState = ACTIVITY_PAUSE;
		Log.i("pause" + this.getClass(), "---------onPause ");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("restart" + this.getClass(), "---------onRestart ");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		activityState = ACTIVITY_DESTROY;
		AppManager.getAppManager().finishActivity(this);
		Log.i("destroy>>" + this.getClass(), "---------onDestroy ");
	}

	public static void showMessage(String msg) {
		Toast.makeText(AppManager.getAppManager().currentActivity(), msg,
				Toast.LENGTH_SHORT).show();
	}

	// protected void getCustomActionBar() {
	// actionBar = getActionBar();
	// actionBar.setDisplayHomeAsUpEnabled(false);
	// actionBar.setDisplayShowHomeEnabled(false);
	//
	// actionBar.setBackgroundDrawable(this.getBaseContext().getResources()
	// .getDrawable(R.drawable.ActionBarBackGround));
	//
	// actionBar.setDisplayShowCustomEnabled(true);
	// actionBar.setCustomView(R.layout.titlebar);
	// iv_home = (ImageView) findViewById(R.id.iv_home);
	// title_rightbutton = (LinearLayout) findViewById(R.id.ll_main_paiban);
	//
	// }

	float down = 0;
	float demp = 0;

	// @Override
	// public boolean onTouchEvent(MotionEvent ev) {
	// switch (ev.getAction()) {
	// case MotionEvent.ACTION_DOWN:
	// down = ev.getY();
	// System.out.println(down);
	// break;
	//
	// case MotionEvent.ACTION_MOVE:
	// demp = ev.getY() - down;
	// System.out.println(demp);
	// if (demp != 0) {
	// if (demp < heigh / 3) {
	// actionBar.hide();
	//
	// } else {
	// actionBar.show();
	//
	// }
	// }
	// break;
	//
	// case MotionEvent.ACTION_UP:
	// break;
	//
	// default:
	// break;
	// }
	// return super.onTouchEvent(ev);
	// }

	// 设置标题栏

	public void BaseSetTitleView(int layoutID) {
		ll_content_title = (LinearLayout) findViewById(R.id.ll_content_title);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// 把继承该BaseAcitivyt的layoutID放进来 显示
		View view = inflater.inflate(layoutID, null);
		view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		// addview
		ll_content_title.addView(view);

	}

	// 设置要显示的布局方法
	public void BaseSetContentView(int layoutID) {
		llcontent = (LinearLayout) findViewById(R.id.ll_content);
		// 获得inflater
		LayoutInflater inflater = LayoutInflater.from(this);
		// 把继承该BaseAcitivyt的layoutID放进来 显示
		View view = inflater.inflate(layoutID, null);
		view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		// addview
		llcontent.addView(view);
	}

	// // 设置要下一个显示的布局
	// public void BaseSetContentView_other(int layoutID) {
	// llcontent = (LinearLayout) findViewById(R.id.ll_content_other);
	// // 获得inflater
	// LayoutInflater inflater = (LayoutInflater)
	// getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	// // 把继承该BaseAcitivyt的layoutID放进来 显示
	// View view = inflater.inflate(layoutID, null);
	// // addview
	// llcontent.addView(view);
	// }

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
		} else {
		}
	}

	/**
	 * Guarantee progressDialog only one instance.
	 */

}