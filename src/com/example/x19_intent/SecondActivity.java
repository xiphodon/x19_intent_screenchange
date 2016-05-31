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
		
		//取到bundle对象
		Bundle bundle = intent.getExtras();
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		
		
		TextView tv_welcome = (TextView) findViewById(R.id.tv_welcome);
		TextView tv_showpassword = (TextView) findViewById(R.id.tv_showpassword);
		
		tv_welcome.setText("欢迎用户：" + username);
		tv_showpassword.setText("你的密码是：" + password);
		
		
		//虚构ListView
		final String[] objects = new String[]{
				"小明",
				"小张",
				"小王",
				"小李"
		};
		
		
		ListView lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(SecondActivity.this, R.layout.item, R.id.tv, objects));
		
		//设置ListView中的条目监听      position能知道点击了哪一个条目
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				//把要传递的数据封装在intent对象中
				Intent intent = new Intent();
				intent.putExtra("name", objects[position]);
				//此Activity一旦销毁，数据就会传递给此Activity的调用者（Activity）    结果码是用来接收数据时通过请求码或结果码来判断是哪一个Activity回传的数据
				setResult(0, intent);
				//销毁此Activity
				finish();
			}
			
		});
	}
	
}
