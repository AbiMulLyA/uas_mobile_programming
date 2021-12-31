package com.chipo.cashier;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chipo.cashier.printer.DeviceListActivity;
import com.chipo.cashier.utils.Constants;
import com.chipo.cashier.utils.Shared;
import com.zj.btsdk.BluetoothService;

public class MainActivity extends Activity implements OnClickListener {
	public static String SesID;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btnMasterData).setOnClickListener(this);
		findViewById(R.id.btnQuickOrder).setOnClickListener(this);
		
		TextView t1 = (TextView)findViewById(R.id.textView1);
		TextView t2 = (TextView)findViewById(R.id.textView2);
		
		t1.setTypeface(Shared.openSansLight);
		t2.setTypeface(Shared.openSansLight);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent = null;
		switch ( v.getId()) {
		case R.id.btnMasterData:
			intent = new Intent(MainActivity.this, MasterListActivity.class);
			break;
		case R.id.btnQuickOrder:
			intent = new Intent(MainActivity.this, QuickOrderActivity.class);
			break;
		default:
			break;
		}
		
		if(intent != null)
		{
			startActivity(intent);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	}
	

}
