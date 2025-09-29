class MinStack {
    Stack<Integer> s= new Stack<>();
    Stack<Integer> t= new Stack<>();
    public MinStack() {
    }
    
    public void push(int val) {
        s.push(val);
        if(!t.isEmpty()){
            if(val<t.peek()) t.push(val);
            else t.push(t.peek());
        }
        else{
            t.push(val);
        }
    }
    
    public void pop() {
        s.pop();
        t.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return t.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */