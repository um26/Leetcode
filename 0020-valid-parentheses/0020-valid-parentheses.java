class Solution {
    public boolean isValid(String s) {
        Stack<Character> ss= new Stack<>();
        char a=s.charAt(0);

        for(int i=0;i<s.length();i++){
            a=s.charAt(i);

            if(a=='(' || a=='[' || a=='{') ss.push(a);
            if(ss.isEmpty()) return false;
            else if(a==')' && ss.pop()!='(') return false;
            else if(a==']' && ss.pop()!='[') return false;
            else if(a=='}' && ss.pop()!='{') return false;
        }
        if(ss.isEmpty()) return true;
        else return false;
    }
}