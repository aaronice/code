public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int element = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() < element) {
                stack.push(helpStack.pop());
            }
            helpStack.push(element);
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }
}
