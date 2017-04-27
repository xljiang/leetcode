package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	private Queue<Integer> q = new LinkedList<Integer>(); 

	// only can use add(), peek(), poll(), size()
	
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
}
