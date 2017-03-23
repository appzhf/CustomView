package com.example.custom.view;

import com.example.custom.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MoblieView extends View {
	
	private int moblieX,moblieY;
	
	public MoblieView(Context context){
		super(context);
	}
	
	public MoblieView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	/**
	 * 重写触屏事件
	 * */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		moblieX = (int) event.getX();
		moblieY = (int) event.getY();
		invalidate();
		postInvalidate();
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		canvas.drawBitmap(bitmap, moblieX, moblieY, null);
		super.onDraw(canvas);
	}
}
