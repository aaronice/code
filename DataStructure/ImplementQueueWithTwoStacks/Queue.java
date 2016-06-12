public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    private void switchStack() {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.empty()) {
            switchStack();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.empty()) {
            switchStack();
        }
        return stack1.peek();
    }
}
