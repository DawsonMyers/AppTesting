package ca.syncron.handlertest;

/**
 * Created by Dawson on 2/3/2015.
 */
public class MyHandlerThread extends android.os.HandlerThread {

MyService mMyService;

public MyHandlerThread(String name) {
	super(name);
}

@Override
public void run() {
	super.run();
}
}
