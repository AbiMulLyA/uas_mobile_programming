package com.chipo.cashier;

import android.Manifest;
import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

public class SplashActivity extends Activity {
	ImageView ivSplash;
	TextView tvSplash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash);
//        Objects.requireNonNull(getSupportActionBar()).hide();

		ivSplash = findViewById(R.id.iv_splash);
		tvSplash = findViewById(R.id.tv_splash);
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
		ivSplash.startAnimation(animation);

		new Handler().postDelayed(() -> {
			tvSplash.setVisibility(View.VISIBLE);
			Animation txt = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
			tvSplash.startAnimation(txt);
		}, 700);

		new Handler(Looper.getMainLooper()).postDelayed(()->{
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(intent);
			overridePendingTransition(anim.fade_in, anim.fade_out);
			finish();
		}, 3500);

	}

	private void goNext()
	{
		Intent intent = new Intent(SplashActivity.this, MainActivity.class);
		startActivity(intent);
		overridePendingTransition(anim.fade_in, anim.fade_out);
		finish();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		boolean allgranted = true;
		for (int i = 0; i < grantResults.length; i++)
		{
			if(PackageManager.PERMISSION_GRANTED != grantResults[i])
			{
				allgranted = false;
			}
		}

		if(!allgranted)
		{
			Toast.makeText(SplashActivity.this,"All permission are required",Toast.LENGTH_LONG).show();
			finish();
		}
		else
        {
            goNext();
        }

	}
}
