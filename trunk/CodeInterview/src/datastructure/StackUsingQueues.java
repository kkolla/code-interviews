package datastructure;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	/**
	Version A (push efficient):
	push:
	enqueue in queue1
	pop:
	while size of queue1 is bigger than 1, pipe dequeued items from queue1 into queue2
	dequeue and return the last item of queue1, then switch the names of queue1 and queue2
	*/
	
	// Push element x onto stack.
    public void push(int x) {
    	q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	move(q1.size() - 1);
    	q1.poll();
    	swap();
    }

    // Get the top element.
    public int top() {
    	if (q1.isEmpty()) throw new EmptyStackException();
    	move(q1.size() - 1);
    	int t = q1.poll();
    	q2.offer(t);
    	swap();
    	return t;
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return q1.isEmpty();
    }
    
    private void move(int times) {
    	for (int i = 0; i < times; i++)
        	if (q1.isEmpty()) throw new EmptyStackException();
        	else q2.offer(q1.poll());
    }
    
    private void swap() {
    	Queue<Integer> temp = q1;
    	q1 = q2;
    	q2 = temp;
    }
    
	/**
	Version B (pop efficient):
	push:
	enqueue in queue2
	enqueue all items of queue1 in queue2, then switch the names of queue1 and queue2
	pop:
	deque from queue1
	 */
    
    public void push2(int x) {
    	q2.offer(x);
    	while (!q1.isEmpty()) q2.offer(q1.poll());
    	swap();
    }
    
    public void pop2() {
    	if (q1.isEmpty()) throw new EmptyStackException();
    	q1.poll();
    }
    
    public int top2() {
    	if (q1.isEmpty()) throw new EmptyStackException();
    	return q1.peek();
    }

	public static void main(String[] args) {
		StackUsingQueues s = new StackUsingQueues();
		s.push(3);
		s.push(4);
		System.out.println(s.empty());
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();

		s.push2(3);
		s.push2(4);
		System.out.println(s.empty());
		System.out.println(s.top());
		s.pop2();
		System.out.println(s.top());
		s.pop2();
	}

}
