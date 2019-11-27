package com.haanhgs.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import android.support.v4.app.FragmentActivity;

public class AndroidLauncher extends FragmentActivity implements AndroidFragmentApplication.Callbacks {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Test test = new Test();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.flMain, test)
				.commit();
	}

	@Override
	public void exit() {

	}
}
