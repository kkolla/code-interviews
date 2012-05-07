package thread;

/*
 * Check that the variable is initialized (without obtaining the lock). 
 * If it is initialized, return it immediately.
 * Obtain the lock.
 * Double-check whether the variable has already been initialized: if another thread acquired the lock first, it may have already done the initialization. If so, return the initialized variable.
 * Otherwise, initialize and return the variable.
 */
public class DoubleCheckedLockedSingleton {

	protected DoubleCheckedLockedSingleton() {
	}

	public static class Creator {
		private static DoubleCheckedLockedSingleton instance;

		public DoubleCheckedLockedSingleton getInstance() {
			if (instance == null) {
				synchronized (this) {
					if (instance == null)
						instance = new DoubleCheckedLockedSingleton();
				}
			}
			return instance;
		}
	}
}
