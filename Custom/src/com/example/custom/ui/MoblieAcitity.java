package com.example.custom.ui;

import com.example.custom.view.MoblieSurfaceView;

import android.app.Activity;
import android.os.Bundle;

public class MoblieAcitity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(new MoblieSurfaceView(this));
		super.onCreate(savedInstanceState);
	}
}
