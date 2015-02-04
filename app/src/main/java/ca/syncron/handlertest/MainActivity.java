package ca.syncron.handlertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.String.format;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
MyService mMyService;
public Button btn1, btn2, btn3, btn4;

public TextView tv1;// = (TextView) findViewById(R.id.tv1);


public MainActivity() {
}

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	Log.i("App", format("MainActivity onCreate"));
	mMyService = MyService.getInstance();
	mMyService.registerInstance(this);

	btn1 = (Button) findViewById(R.id.btn1);
	btn2 = (Button) findViewById(R.id.btn2);
	btn3 = (Button) findViewById(R.id.btn3);
	btn4 = (Button) findViewById(R.id.btn4);

	tv1 = (TextView) findViewById(R.id.tv1);

	btn1.setOnClickListener(this);
	btn2.setOnClickListener(this);
	btn3.setOnClickListener(this);
	btn4.setOnClickListener(this);
}


@Override
protected void onPause() {
	super.onPause();
	mMyService.unregisterInstance(this);
	Log.i("App", format("MainActivity onPause"));
}

@Override
protected void onResume() {
	super.onResume();
	Log.i("App", format("MainActivity onResume"));
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu_main, menu);
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();

	//noinspection SimplifiableIfStatement
	if (id == R.id.action_settings) {
		return true;
	}

	return super.onOptionsItemSelected(item);
}

@Override
public void onClick(View v) {
	switch (v.getId()) {
		case R.id.btn1:
			startActivity(new Intent(MainActivity.this, SecondActivity.class));
			break;
		case R.id.btn2:
			mMyService.setText("You added this text!!!");

			break;
		case R.id.btn3:
			break;
		case R.id.btn4:
			break;
	}
}
}
