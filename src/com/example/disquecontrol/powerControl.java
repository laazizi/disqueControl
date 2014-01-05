package com.example.disquecontrol;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class powerControl extends SeekBar {
	private int power;

	public powerControl(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public powerControl(Context context, AttributeSet attrs) {
		super(context, attrs);
 
	}

	public void callBack() {

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(h, w, oldh, oldw);
	}

	@Override
	protected synchronized void onMeasure(int widthMeasureSpec,
			int heightMeasureSpec) {

		super.onMeasure(heightMeasureSpec, widthMeasureSpec);
		setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
	}

 

	@Override
	public void setProgressDrawable(Drawable d) {
	//	Resources dd = getResources();
	//	d = dd.getDrawable(R.drawable.bar);
	 //
		//Canvas c= new Canvas();
		//Paint paint= new Paint();
	//	paint.setColor(Color.RED);
	//	c.drawRect(5, 5, 100, 100, paint);
		//invalidate();
		//d.draw(c);
	
		super.setProgressDrawable(d);
	}

	@Override
	public void setThumb(Drawable thumb) {
		Resources d = getResources();
		thumb = d.getDrawable(R.drawable.compass_base);
		super.setThumb(thumb);
	}

	@Override
	protected synchronized void onDraw(Canvas canvas) {
		canvas.rotate(90);

		canvas.translate(0, -getWidth());

		// canvas.drawRect(0, 0, 50, 50, paint);
		super.onDraw(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (!isEnabled()) {
			return false;
		}
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_MOVE:
			int i = 0;
			i = getMax() - (int) (getMax() * event.getY() / getHeight());
			if (i>100){i=100;}
			if (i<0){i=0;}
			setProgress(100 - i);
			setPower(100 - i);
			
			onSizeChanged(getWidth(), getHeight(), 0, 0);
		case MotionEvent.ACTION_UP:
			
			break;
		case MotionEvent.ACTION_OUTSIDE:
			 
			break;
		case MotionEvent.ACTION_CANCEL:
			 
			break;
		}
		return true;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
