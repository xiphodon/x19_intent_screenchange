package com.example.x19_intent;

import com.example.x19_intent.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent intent = getIntent();
//		String username = intent.getStringExtra("username");
//		String password = intent.getStringExtra("password");
		
		//ȡ��bundle����
		Bundle bundle = intent.getExtras();
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		
		
		TextView tv_welcome = (TextView) findViewById(R.id.tv_welcome);
		TextView tv_showpassword = (TextView) findViewById(R.id.tv_showpassword);
		
		tv_welcome.setText("��ӭ�û���" + username);
		tv_showpassword.setText("��������ǣ�" + password);
		
		
		//�鹹ListView
		final String[] objects = new String[]{
				"С��",
				"С��",
				"С��",
				"С��"
		};
		
		
		ListView lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(SecondActivity.this, R.layout.item, R.id.tv, objects));
		
		//����ListView�е���Ŀ����      position��֪���������һ����Ŀ
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				//��Ҫ���ݵ����ݷ�װ��intent������
				Intent intent = new Intent();
				intent.putExtra("name", objects[position]);
				//��Activityһ�����٣����ݾͻᴫ�ݸ���Activity�ĵ����ߣ�Activity��    �������������������ʱͨ����������������ж�����һ��Activity�ش�������
				setResult(0, intent);
				//���ٴ�Activity
				finish();
			}
			
		});
	}
	
}
