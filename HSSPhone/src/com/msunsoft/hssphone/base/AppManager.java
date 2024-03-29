package com.msunsoft.hssphone.base;


import java.util.Stack;

import android.app.Activity;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 * 
 * 
 * 
 */

public class AppManager {

	private static Stack<BaseActivity> activityStack;
	private static AppManager instance;

	private AppManager() {
	}

	/**
	 * 单实例 , UI无需考虑多线程同步问题
	 */
	public static AppManager getAppManager() {
		if (instance == null) {
			instance = new AppManager();
		}
		return instance;
	}

	/**
	 * 添加Activity到栈
	 */
	public void addActivity(BaseActivity activity) {
		if (activityStack == null) {
			activityStack = new Stack<BaseActivity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 获取当前Activity（栈顶Activity）
	 */
	public BaseActivity currentActivity() {
		if (activityStack == null || activityStack.isEmpty()) {
			return null;
		}
		BaseActivity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 获取当前Activity（栈顶Activity） 没有找到则返回null
	 */
	public BaseActivity findActivity(Class<?> cls) {
		BaseActivity activity = null;
		for (BaseActivity aty : activityStack) {
			if (aty.getClass().equals(cls)) {
				activity = aty;
				break;
			}
		}
		return activity;
	}

	/**
	 * 结束当前Activity（栈顶Activity）
	 */
	public void finishActivity() {
		BaseActivity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 结束指定的Activity(重载)
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定的Activity(重载)
	 */
	public void finishActivity(Class<?> cls) {
		for (BaseActivity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
	 * 
	 * @param cls
	 */
	public void finishOthersActivity(Class<?> cls) {
		for (BaseActivity activity : activityStack) {
			if (!(activity.getClass().equals(cls))) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 应用程序退出
	 */
//	@SuppressLint("NewApi")
//	public void AppExit(Context context) {
//		try {
//			finishAllActivity();
//			ActivityManager activityManager = (ActivityManager) context
//					.getSystemService(Context.ACTIVITY_SERVICE);
//			activityManager.killBackgroundProcesses(context.getPackageName());
//			System.exit(0);
//		} catch (Exception e) {
//			System.exit(0);
//		}
//	}

}


