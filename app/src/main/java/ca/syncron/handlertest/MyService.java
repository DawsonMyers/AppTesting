package ca.syncron.handlertest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class MyService extends Service implements TestConstants{

public static Map<String, Object> mInstanceArrayList = new HashMap<>();

private static MyService ourInstance = new MyService();

public static MyService getInstance() {
	Log.i("App",format("MyService instance returned" ));
	return ourInstance;

}

public MyService() {
}

@Override
public IBinder onBind(Intent intent) {
	return null;
}

@Override
public void onCreate() {
	super.onCreate();
	Log.i("App", "MyService created");
	registerInstance(this);
}
public static void registerInstance(Object instance){
	String name = instance.getClass().getName();
	 if(!(mInstanceArrayList.containsKey(name))){
		 mInstanceArrayList.put(name, instance);
		 Log.i("App",format("%s registered",name ));
	 }
}
public static void unregisterInstance(Object instance){
	String name = instance.getClass().getName();
	 if(mInstanceArrayList.containsKey(name)){
		 mInstanceArrayList.remove(name);
		 Log.i("App",format("%s unregistered",name ));
	 }
}
public static Object getRegisteredInstance(String name){
	 if(mInstanceArrayList.containsKey(name)){
		 Log.i("App",format("%s intsance retrieved",name ));
		 return mInstanceArrayList.get(name);
	 }
	return null;
}

@Override
public void getName() {

}

public void setText(String s) {
	MainActivity mainActivity = (MainActivity) getRegisteredInstance(MainActivity.class.getName());
	Log.i("App",format("TextView text set to: %s",s ));
	TextView tv1 = (TextView) mainActivity.findViewById(R.id.tv1);
	tv1.setText(s);
}
}

