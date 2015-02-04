package ca.syncron.handlertest;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import static java.lang.String.format;

/**
 * Created by Dawson on 2/3/2015.
 */
public class App extends Application {
MyService mMyService;

public App() {
}

@Override
public void onCreate() {
	super.onCreate();
	if (mMyService == null) {
		mMyService = new MyService();
		startService(new Intent(this, MyService.class));
	}
	mMyService.registerInstance(this);

	Log.i("App", format("App started"));
}



}
