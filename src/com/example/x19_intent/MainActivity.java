package com.example.x19_intent;

import android.os.Bundle;
import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		// //锁定横屏
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		// //锁定竖屏
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	public void login(View v) {
		EditText et_username = (EditText) findViewById(R.id.et_username);
		EditText et_password = (EditText) findViewById(R.id.et_password);

		String username = et_username.getText().toString();
		String password = et_password.getText().toString();

		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		// 把数据封装在intent对象中
		// intent.putExtra("username", username);
		// intent.putExtra("password", password);

		// 把数据封装至bundle对象中
		Bundle bundle = new Bundle();
		bundle.putString("username", username);
		bundle.putString("password", password);
		// 把bundle封装至intent对象中
		intent.putExtras(bundle);

		// startActivity(intent);
		// 告诉系统，跳转的Activity会返回数据                请求码是用来接收数据时通过请求码或结果码来判断是哪一个Activity回传的数据
		startActivityForResult(intent, 1);

	}

	// 当要返回数据到当前Activity的Activity销毁时，此方法调用，接收数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		String name = data.getStringExtra("name");
		
		EditText et_return = (EditText) findViewById(R.id.et_return);
		et_return.setText(name);
	}

}
