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
		// //��������
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		// //��������
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	public void login(View v) {
		EditText et_username = (EditText) findViewById(R.id.et_username);
		EditText et_password = (EditText) findViewById(R.id.et_password);

		String username = et_username.getText().toString();
		String password = et_password.getText().toString();

		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		// �����ݷ�װ��intent������
		// intent.putExtra("username", username);
		// intent.putExtra("password", password);

		// �����ݷ�װ��bundle������
		Bundle bundle = new Bundle();
		bundle.putString("username", username);
		bundle.putString("password", password);
		// ��bundle��װ��intent������
		intent.putExtras(bundle);

		// startActivity(intent);
		// ����ϵͳ����ת��Activity�᷵������                ��������������������ʱͨ����������������ж�����һ��Activity�ش�������
		startActivityForResult(intent, 1);

	}

	// ��Ҫ�������ݵ���ǰActivity��Activity����ʱ���˷������ã���������
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		String name = data.getStringExtra("name");
		
		EditText et_return = (EditText) findViewById(R.id.et_return);
		et_return.setText(name);
	}

}
