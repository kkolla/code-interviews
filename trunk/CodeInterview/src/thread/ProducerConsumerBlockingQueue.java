package thread;

public class ProducerConsumerBlockingQueue {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		if (!valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		if (valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}

	class Producer implements Runnable {
		ProducerConsumerBlockingQueue q;

		Producer(ProducerConsumerBlockingQueue q) {
			this.q = q;
			new Thread(this, "Producer").start();
		}

		public void run() {
			int i = 0;
			while (true) {
				q.put(i++);
			}
		}
	}

	class Consumer implements Runnable {
		ProducerConsumerBlockingQueue q;

		Consumer(ProducerConsumerBlockingQueue q) {
			this.q = q;
			new Thread(this, "Consumer").start();
		}

		public void run() {
			while (true) {
				q.get();
			}
		}
	}

	public void start() {
		new Producer(this);
		new Consumer(this);
		System.out.println("Press Control-C to stop.");
	}

	public static void main(String[] args) {

		ProducerConsumerBlockingQueue q = new ProducerConsumerBlockingQueue();
		q.start();
	}

}
