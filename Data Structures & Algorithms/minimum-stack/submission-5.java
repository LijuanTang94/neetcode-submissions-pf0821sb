class MinStack {
    Stack<Integer> stack;
    Stack<int[]> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val < min.peek()[0]) {
            min.push(new int[]{val, 1});
        } else if (val == min.peek()[0]){
            min.peek()[1]++;
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == min.peek()[0]) {
            if (--min.peek()[1] == 0) {
                min.pop();
            }
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek()[0];
    }
}
