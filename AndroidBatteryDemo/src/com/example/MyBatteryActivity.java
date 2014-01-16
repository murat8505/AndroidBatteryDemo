package com.example;

import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class MyBatteryActivity extends Activity {


	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battery);

		tv= (TextView)findViewById(R.id.txt2);
		registerReceiver(this.batteryInformationReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

	}

	BroadcastReceiver batteryInformationReceiver= new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub

			int  health= intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
			int  level= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
			int  plugged= intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
			boolean  present= intent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT); 
			int  status= intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
			String  technology= intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
			int  temperature= intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
			int  voltage= intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);

			tv.setText("------------My Battery Information------------" + "\n" +
					"Health: "+health+"\n"+
					"Level: "+level+"\n"+
					"Plugged: "+plugged+"\n"+
					"Present: "+present+"\n"+
					"Status: "+status+"\n"+
					"Technology: "+technology+"\n"+
					"Temperature: "+temperature+"\n"+
					"Voltage: "+voltage+"\n");

		}
	};
}
