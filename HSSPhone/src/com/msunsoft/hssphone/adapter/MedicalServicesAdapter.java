/**
 * 
 */
package com.msunsoft.hssphone.adapter;

import java.util.List;

import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.activity.AntibacterialDrugsActivity;
import com.msunsoft.hssphone.activity.BasicSituationActivity;
import com.msunsoft.hssphone.activity.BothTimesTheCostActivity;
import com.msunsoft.hssphone.activity.CareQualitySupervisionActivity;
import com.msunsoft.hssphone.activity.ClinicalQualityControlActivity;
import com.msunsoft.hssphone.activity.EfficiencyActivity;
import com.msunsoft.hssphone.activity.EssentialDrugsActivity;
import com.msunsoft.hssphone.activity.IncreaseRevenueActivity;
import com.msunsoft.hssphone.activity.MedicalServicesActivity;
import com.msunsoft.hssphone.activity.MedicareExecutionActivity;
import com.msunsoft.hssphone.activity.PharmaceuticalQualityControlActivity;
import com.msunsoft.hssphone.activity.ProfitabilityActivity;
import com.msunsoft.hssphone.activity.QualityMonitoringActivity;
import com.msunsoft.hssphone.activity.QualityOfCareActivity;
import com.msunsoft.hssphone.activity.ServiceEfficiencyActivity;
import com.msunsoft.hssphone.activity.SourcesOfPatientActivity;
import com.msunsoft.hssphone.activity.TheBasicDrugUseActivity;
import com.msunsoft.hssphone.activity.WorkloadActivity;
import com.msunsoft.hssphone.entity.MedicalService;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author lili.guo
 * 
 *         2014-8-26
 */
public class MedicalServicesAdapter extends BaseAdapter {

	private Context context;
	private List<MedicalService> list;
	private boolean onclick = true;
	private int[] image={R.drawable.medical1,
			R.drawable.medical2,
			R.drawable.medical3,
			R.drawable.medical4,
			R.drawable.medical5,
			R.drawable.medical6,
			R.drawable.medical7,
			R.drawable.medical8,
			R.drawable.medical9,
			R.drawable.medical10};

	public MedicalServicesAdapter(Context context, List<MedicalService> list) {
		super();
		this.context = context;
		this.list = list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return list.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		view = LayoutInflater.from(context).inflate(
				R.layout.adapter_medicalservice, null);
		LinearLayout ll_medical_service_onclick = (LinearLayout) view
				.findViewById(R.id.ll_medical_service_onclick);
		LinearLayout ll_medical_service_three = (LinearLayout) view
				.findViewById(R.id.ll_medical_service_three);
		TextView tv_medicalservice_string1 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string1);
		TextView tv_medicalservice_string2 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string2);
		TextView tv_medicalservice_string3 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string3);
		TextView tv_medicalservice_string4 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string4);
		TextView tv_medicalservice_string5 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string5);
		TextView tv_medicalservice_string6 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string6);
		TextView tv_medicalservice_string7 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string7);
		TextView tv_medicalservice_string8 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string8);
		TextView tv_medicalservice_string9 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string9);
		TextView tv_medicalservice_string10 = (TextView) view
				.findViewById(R.id.tv_medicalservice_string10);
		ImageView iv_medical_services_a = (ImageView) view
				.findViewById(R.id.iv_medical_services_a);
		final LinearLayout ll_medical_service = (LinearLayout) view
				.findViewById(R.id.ll_medical_service);
		ll_medical_service_onclick.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (onclick == true) {
					ll_medical_service.setVisibility(View.VISIBLE);
					onclick = false;
				} else {
					ll_medical_service.setVisibility(View.GONE);
					onclick = true;
				}
			}
		});
		iv_medical_services_a.setImageResource(image[arg0]);
		tv_medicalservice_string1.setText(list.get(arg0).getString1());
		tv_medicalservice_string2.setText(list.get(arg0).getString2());
		tv_medicalservice_string3.setText(list.get(arg0).getString3());
		tv_medicalservice_string4.setText(list.get(arg0).getString4());
		tv_medicalservice_string5.setText(list.get(arg0).getString5());
		tv_medicalservice_string6.setText(list.get(arg0).getString6());
		tv_medicalservice_string7.setText(list.get(arg0).getString7());
		tv_medicalservice_string8.setText(list.get(arg0).getString8());
		tv_medicalservice_string9.setText(list.get(arg0).getString9());
		tv_medicalservice_string10.setText(list.get(arg0).getString10());

		if (TextUtils.isEmpty(list.get(arg0).getString8())) {
			ll_medical_service_three.setVisibility(View.GONE);
		}
		
		if (TextUtils.isEmpty(list.get(arg0).getString9())) {
			tv_medicalservice_string9.setVisibility(View.GONE);
		}
		if (TextUtils.isEmpty(list.get(arg0).getString10())) {
			tv_medicalservice_string10.setVisibility(View.GONE);
		}
		if (TextUtils.isEmpty(list.get(arg0).getString7())) {
			tv_medicalservice_string7.setVisibility(View.GONE);
		}

		if ("*基本药物使用监管".equals(list.get(arg0).getString3())) {
			tv_medicalservice_string3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, EssentialDrugsActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*收益能力".equals(list.get(arg0).getString4())) {
			tv_medicalservice_string4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, ProfitabilityActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*基本情况".equals(list.get(arg0).getString2())) {
			tv_medicalservice_string2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, BasicSituationActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*收入增长".equals(list.get(arg0).getString5())) {
			tv_medicalservice_string5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, IncreaseRevenueActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*治疗质量".equals(list.get(arg0).getString5())) {
			tv_medicalservice_string5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, QualityOfCareActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*病人来源分析".equals(list.get(arg0).getString5())) {
			tv_medicalservice_string5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, SourcesOfPatientActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*服务效率".equals(list.get(arg0).getString4())) {
			tv_medicalservice_string4.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, ServiceEfficiencyActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*质量控制".equals(list.get(arg0).getString3())) {
			tv_medicalservice_string3.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, QualityMonitoringActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*工作负荷".equals(list.get(arg0).getString2())) {
			tv_medicalservice_string2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, WorkloadActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*工作效率".equals(list.get(arg0).getString8())) {
			tv_medicalservice_string8.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, EfficiencyActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*医保执行".equals(list.get(arg0).getString5())) {
			tv_medicalservice_string5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, MedicareExecutionActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*均次成本".equals(list.get(arg0).getString5())) {
			tv_medicalservice_string5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, BothTimesTheCostActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*护理质量监管".equals(list.get(arg0).getString6())) {
			tv_medicalservice_string6.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, CareQualitySupervisionActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*抗菌药物监管指标".equals(list.get(arg0).getString8())) {
			tv_medicalservice_string8.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, AntibacterialDrugsActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*药事质控".equals(list.get(arg0).getString3())) {
			tv_medicalservice_string3.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, PharmaceuticalQualityControlActivity.class);
					context.startActivity(intent);
				}
			});
		}
		if ("*临床质控".equals(list.get(arg0).getString2())) {
			tv_medicalservice_string2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(context, ClinicalQualityControlActivity.class);
					context.startActivity(intent);
				}
			});
		}
//		if ("*基本药物使用监管".equals(list.get(arg0).getString3())) {
//			tv_medicalservice_string3.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View arg0) {
//					Intent intent = new Intent();
//					intent.setClass(context, TheBasicDrugUseActivity.class);
//					context.startActivity(intent);
//				}
//			});
//		}
		return view;
	}

}
