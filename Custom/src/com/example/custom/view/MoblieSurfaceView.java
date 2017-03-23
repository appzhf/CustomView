package com.example.custom.view;

import com.example.custom.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MoblieSurfaceView extends SurfaceView implements Callback{
	private static final String TAG=MoblieSurfaceView.class.getSimpleName();
	private SurfaceHolder sfh;
	private Canvas canvas;//画布
	private Thread th;//声明一个线程
	private boolean flag;//线程消亡的标志
	//图片数组
	private int imgs[] = {R.drawable.yu1,R.drawable.yu2,R.drawable.yu3,R.drawable.yu4};
	private Bitmap bm[] = new Bitmap[imgs.length];
	// 图的x，y坐标
	private int bmX, bmY;
	private int index = 0;
	
	public MoblieSurfaceView(Context context) {
		super(context);
		//实例化SurfaceHolder
		sfh = getHolder();
		//SurfaceHolder添加监听
		sfh.addCallback(this);
		// 设置焦点
		setFocusable(true);
		for (int i = 0; i < imgs.length; i++) {
			bm[i] = BitmapFactory.decodeResource(getResources(), imgs[i]);
			bmX = -bm[i].getWidth() + this.getWidth();
			bmY = bm[i].getHeight() - this.getHeight();
		}
	}
	
	public MoblieSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		flag = true;
		th = new Thread(){
			@Override
			public void run() {
				while(flag){
					long start = System.currentTimeMillis();
					myDraw();
					logic();
					long end = System.currentTimeMillis();
					if(end - start<50){
						try {
							Thread.sleep(50 - (end - start));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				super.run();
			}
		};
		//启动线程
		th.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		flag = false;
		
	}
	
	private void myDraw(){
		try {
			canvas = sfh.lockCanvas();
			if (null != canvas) {
				
				canvas.drawRGB(0, 0, 0);
				canvas.drawBitmap(bm[index], bmX, bmY, null);
				
			}
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}finally{
			if(null != canvas)
				sfh.unlockCanvasAndPost(canvas);
		}
	}
	private void logic(){
		index++;
		if (index >= bm.length) {
			index = 0;
			if (bmX > this.getWidth()) {
				bmX = 0;
			}
		}
		bmX += 5;
	}
}
