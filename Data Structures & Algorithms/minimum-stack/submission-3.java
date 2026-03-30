class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        min.push(min.isEmpty() ? val : Math.min(min.peek(), val));
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            min.pop();
        }
        
    }
    
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if (min.isEmpty()) return -1;
        return min.peek();
    }
}
