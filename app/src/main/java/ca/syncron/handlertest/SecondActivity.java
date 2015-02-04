package ca.syncron.handlertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity implements View.OnClickListener {

private MyService mMyService;
public  Button    btnReturn;
public  TextView  tv1;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_second);
	mMyService = MyService.getInstance();
	mMyService.registerInstance(this);

	btnReturn = (Button) findViewById(R.id.btnReturn);

	tv1 = (TextView) findViewById(R.id.tv1);

	btnReturn.setOnClickListener(this);
}

@Override
protected void onPause() {
	super.onPause();
	mMyService.unregisterInstance(this);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu_second, menu);
	menu.add(1, 1, 1, "Dawson");
	menu.add(1, 2, 1, "App");
	menu.add("Bingo!");
	return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	switch (id) {
		case 1:
			//startActivity(new Intent(SecondActivity.this, MainActivity.class));
			LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = vi.inflate(R.layout.my_linear_layout, null);
// fill in any details dynamically here
			TextView textView = (TextView) v.findViewById(R.id.tv1);
			textView.setText("Menu Insert 1");
// insert into main view
			ViewGroup insertPoint = (ViewGroup) findViewById(R.id.LL1);
			insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
			break;
		case 2:
			//startActivity(new Intent(SecondActivity.this, MainActivity.class));
			LayoutInflater vi1 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v1 = vi1.inflate(R.layout.my_linear_layout2, null);
// fill in any details dynamically here
			TextView textView1 = (TextView) v1.findViewById(R.id.tv1);
			textView1.setText("Menu Insert 2");
// insert into main view
			ViewGroup insertPoint1 = (ViewGroup) findViewById(R.id.LL1);
			insertPoint1.addView(v1, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
			break;

	}

	//noinspection SimplifiableIfStatement
	if (id == R.id.action_settings) {
		return true;
	}

	return super.onOptionsItemSelected(item);
}

@Override
public void onClick(View v) {
	switch (v.getId()) {
		case R.id.btnReturn:
			startActivity(new Intent(SecondActivity.this, MainActivity.class));
			break;
		case R.id.btn2:
			break;
		case R.id.btn3:
			break;
		case R.id.btn4:
			break;
	}
}
}
