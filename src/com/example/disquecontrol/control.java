package com.example.disquecontrol;

 
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
 
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;

public class control extends View {
 
	private Bitmap bmp;
	private float a=0;
 
	private Matrix matrix;
	private float px;
	private float py;
	private Bitmap tete;
	private float angle=0;
	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	private float mPreviousX;
	private float mPreviousY;

	public control(Context context) {
		super(context);
		 bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.circle2);
	 
	}

	public control(Context context, AttributeSet attrs) {
		
		super(context, attrs);
 

		 
		 bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.circle2);
		 tete = BitmapFactory.decodeResource(context.getResources(), R.drawable.vis);
		 
	       matrix = new Matrix();
	       px = bmp.getWidth()/2;
	       py = bmp.getHeight()/2;
	
	}

	 
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	    int parentWidth = bmp.getWidth();
	    int parentHeight = bmp.getHeight();
	    this.setMeasuredDimension(
	            parentWidth  , parentHeight);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
	        
	       
	  
	        matrix.postTranslate(-bmp.getWidth()/2, -bmp.getHeight()/2);
	        matrix.postRotate(angle);
	        
	        matrix.postTranslate(px, py);
	        canvas.drawBitmap(bmp, matrix, null);
	        canvas.drawBitmap(tete, bmp.getWidth()/2-tete.getWidth()/2,bmp.getHeight()/2-tete.getHeight()/2, null);
	        matrix.reset();
	       
	}
	
	 @Override
	public boolean onTouchEvent(MotionEvent event) {
		
		
	
		  
		 if (event != null)
		    {
		        float x = event.getX();
		        float y = event.getY();
		 
		        if (event.getAction() == MotionEvent.ACTION_MOVE)
		        {
		           
		                float deltaX = (x - 128) ;
		                float deltaY = (y - 128) ;
		 
		                angle =   -(float)( Math.atan2(deltaX,deltaY)* 180 / Math.PI);
		                
		                invalidate();
		        }
		        if (event.getAction() == MotionEvent.ACTION_UP)
		        {
		           
		              
		 
		                angle =   0;
		                invalidate();
		        }
		        mPreviousX = x;
		        mPreviousY = y;
		 
		        return true;
		    }
		    else
		    {
		        return super.onTouchEvent(event);
		    }
		
	}
	
}
