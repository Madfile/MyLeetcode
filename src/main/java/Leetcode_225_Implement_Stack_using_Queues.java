import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_225_Implement_Stack_using_Queues {
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            int size = queue.size();
            for (int i = 1; i < size; i++) {
                queue.offer(queue.poll());
            }

            return queue.poll();
        }

        public int top() {
            int size = queue.size();
            for (int i = 1; i < size; i++) {
                queue.offer(queue.poll());
            }

            int result = queue.peek();
            queue.offer(queue.poll());

            return result;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
