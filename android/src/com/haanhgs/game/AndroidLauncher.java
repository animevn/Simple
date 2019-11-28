package com.haanhgs.game;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class AndroidLauncher extends FragmentActivity implements AndroidFragmentApplication.Callbacks {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Fragment fragment = getSupportFragmentManager().findFragmentByTag("menu");
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		if (fragment == null){
			FragmentMenu menu = new FragmentMenu();
			ft.replace(R.id.flMain, menu, "menu");
			ft.commit();
		}else {
			ft.attach(fragment);
		}
	}

	@Override
	public void exit() {

	}
}
