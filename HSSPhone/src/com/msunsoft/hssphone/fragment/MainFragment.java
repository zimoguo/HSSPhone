/**
 * 
 */
package com.msunsoft.hssphone.fragment;

import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.activity.MedicalServicesActivity;
import com.msunsoft.hssphone.activity.PublicHealthActivity;
import com.msunsoft.hssphone.activity.RegionalHealthInformationOverviewActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author lili.guo
 * 
 *         2014-8-25
 */
public class MainFragment extends Fragment {

	private ImageView iv_information_overview;
	private ImageView iv_medical_services;
	private ImageView iv_public_health;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, null);
		iv_information_overview = (ImageView) view
				.findViewById(R.id.iv_information_overview);
		iv_medical_services = (ImageView) view
				.findViewById(R.id.iv_medical_services);
		iv_public_health = (ImageView) view.findViewById(R.id.iv_public_health);

		iv_information_overview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setClass(getActivity(), RegionalHealthInformationOverviewActivity.class);
				startActivity(intent);
			}
		});
		iv_medical_services.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setClass(getActivity(), MedicalServicesActivity.class);
				startActivity(intent);
			}
		});

		iv_public_health.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent();
				intent.setClass(getActivity(), PublicHealthActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}

}
