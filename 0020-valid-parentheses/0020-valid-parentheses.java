class Solution {
    public boolean isValid(String s) {
        Stack<Character> a= new Stack<>();

        for(char c : s.toCharArray()){
            if( c=='(' || c=='{' || c=='[') a.push(c);
            else{
                if((c==')' || c==']' || c=='}') && a.isEmpty()) return false;
                else if(c==')' && a.peek()!='(') return false;
                else if(c=='}' && a.peek()!='{') return false;
                else if(c==']' && a.peek()!='[') return false;
                else a.pop();
            }
        }
        return (a.isEmpty());
    }
}