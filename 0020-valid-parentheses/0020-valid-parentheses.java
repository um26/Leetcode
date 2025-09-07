class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>(); 
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            if(stack.isEmpty()) return false;
            else if(s.charAt(i)==')' && stack.pop()!='(') return false;
            else if(s.charAt(i)=='}' && stack.pop()!='{') return false;
            else if(s.charAt(i)==']' && stack.pop()!='[') return false;
        }
        if(stack.size()!=0) return false;
        return true;
    }
}