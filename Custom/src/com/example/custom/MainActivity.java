package com.example.custom;

import com.example.custom.ui.MoblieAcitity;
import com.example.custom.view.MoblieSurfaceView;
import com.example.custom.view.MoblieView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button button2;
	MoblieView mob1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}
	/**
	 * 初始化View
	 * */
	private void initView() {
		button2 = (Button) findViewById(R.id.button2);
		//添加OnClick监听
		button2.setOnClickListener(this);
		mob1 = (MoblieView) findViewById(R.id.mob1);
		
	}

	@Override
	public void onClick(View arg0) {
		if (arg0.getId() == R.id.button2) {
			startActivity(new Intent(this, MoblieAcitity.class));
		}
	}
}
