package ca.syncron.handlertest;

/**
 * Created by Dawson on 2/3/2015.
 */
public class MySingleton {
private static MySingleton ourInstance = new MySingleton();

public static MySingleton getInstance() {
	return ourInstance;
}

private MySingleton() {
}
}
