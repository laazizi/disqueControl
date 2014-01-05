package com.example.disquecontrol;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private powerControl pc;
	private control rot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rot = (control) findViewById(R.id.control1);
		rot.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				TextView tturn = (TextView) findViewById(R.id.textView2);
				tturn.setText("angle :" + rot.getAngle());
				return false;
			}
		});
		pc = (powerControl) findViewById(R.id.powerControl1);
		pc.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				TextView t = (TextView) findViewById(R.id.textView1);
				t.setText("value" + pc.getPower());
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
