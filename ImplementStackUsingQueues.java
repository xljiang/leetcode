package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	// push O(n), pop O(1), top O(1)
	
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    
    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
	
/* my old implementation

	private Queue<Integer> q;

	// only can use add(), peek(), poll(), size()
	
	// instructor
	public ImplementStackUsingQueues() {
		q = new LinkedList<Integer>();
	}
	
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int count = q.size();
        while (count > 1){
        	q.add(q.poll());
        	count--;
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        int count = q.size();
        while (count > 1){
        	q.add(q.poll());
        	count--;
        }
        int top = q.poll();
        q.add(top);
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
*/
	


}
