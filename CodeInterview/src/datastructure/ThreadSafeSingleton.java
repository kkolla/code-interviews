package datastructure;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance = null;
    private static Object syncObj = new Object();
    
    private ThreadSafeSingleton() {} // to prevent new ThreadSafeSingleton()
    
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) { // pure optimization?
            synchronized(syncObj) {
                if (instance == null) // to avoid duplicate instantiations
                    instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }
}
