class MyStack {

    Queue<Integer> s1= new LinkedList<>();
    Queue<Integer> s2= new LinkedList<>();

    public MyStack() {
    }
    
    public void push(int x) {
        if(s1.isEmpty()) s1.add(x);
        else{
            s2.add(x);
            while(!s1.isEmpty()){
                s2.add(s1.poll());
            }
            while(!s2.isEmpty()){
                s1.add(s2.poll());
            }

        }
    }
    
    public int pop() {
        return s1.poll();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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