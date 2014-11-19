/**
 * 
 */
package com.msunsoft.hssphone.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.msunsoft.hssphone.R;
import com.msunsoft.hssphone.adapter.MedicalServicesAdapter;
import com.msunsoft.hssphone.base.BaseActivity;
import com.msunsoft.hssphone.entity.MedicalService;

/**
 * 医疗服务
 * @author lili.guo
 *
 * 2014-8-25
 */
public class MedicalServicesActivity extends BaseActivity {
	
	private ListView lv_medicalservice;
	private List<MedicalService> list;
	private MedicalServicesAdapter adapter;
	private LinearLayout iv_home;
	private TextView tv_baseactivity_titlemiddle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BaseSetTitleView(R.layout.titlebar);
		BaseSetContentView(R.layout.activity_medicalservices);
		
		lv_medicalservice=(ListView) findViewById(R.id.lv_medicalservice);
		iv_home=(LinearLayout) findViewById(R.id.iv_home);
		tv_baseactivity_titlemiddle=(TextView) findViewById(R.id.tv_baseactivity_titlemiddle);
		
		tv_baseactivity_titlemiddle.setText("医疗服务");
		iv_home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		list=new ArrayList<MedicalService>();
		list.add(new MedicalService("医院经济运行指标体系", "*基本情况", "资产负债", "*收益能力", "*收入增长", "成本水平", "关键指标","","",""));
		list.add(new MedicalService("财务指标监管指标体系", "预算执行能力", "结余指标", "偿债能力", "资产运营", "成本管理", "发展能力","业务工作量","",""));
		list.add(new MedicalService("成本水平监管指标体系", "结余分析", "成本构成分析", "诊次床日分析", "量本利分析", "指标分析", "","","",""));
		list.add(new MedicalService("国有资产监管指标体系", "固定资产总量", "固定资产分布", "固定资产报废", "固定资产采购分析", "物资材料库存分析", "高值耗材使用","物资材料采购分析","",""));
		list.add(new MedicalService("人力资源监管指标体系", "人事分析", "资源配置", "工作负荷", "*治疗质量", "工作效率", "患者负担","经济效益","科研成果",""));
		list.add(new MedicalService("医疗保障监管指标体系", "医保总量分析", "总额付费分析", "病种付费分析", "*病人来源分析", "病种费用分析", "","","",""));
		list.add(new MedicalService("医疗质量监管指标体系", "*临床质控", "*药事质控", "诊疗监管", "医技检查监管", "*护理质量监管", "医疗安全指标","*抗菌药物监管指标","",""));
		list.add(new MedicalService("医疗服务检测指标体系", "工作负荷", "效率效益", "医保费用", "*均次成本", "收费水平", "收益指标","工作效率","",""));
		list.add(new MedicalService("基本药物检测指标体系", "药物到货监管", "*基本药物使用监管", "基层药库管理", "基本药物不良反应报告", "基本药物目录管理", "库存药品分析","合理用药","",""));
		list.add(new MedicalService("医生医疗行为检测指标体系", "*工作负荷", "*质量控制", "*服务效率", "*医保执行", "均次成本",  "收益指标","*工作效率","",""));
		adapter=new MedicalServicesAdapter(MedicalServicesActivity.this, list);
		lv_medicalservice.setAdapter(adapter);
		
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}


}
