class Solution {
    public boolean isValid(String s) {
        Stack<Character> ss= new Stack<>();
        char a=s.charAt(0);
        if(a==')' || a==']' || a=='}') return false;

        for(int i=0;i<s.length();i++){
            a=s.charAt(i);

            if(a=='(' || a=='[' || a=='{') ss.push(a);
            else{
                if(ss.isEmpty()) return false;
                char b=ss.pop(); 
                if(a==')' && b!='(') return false;
                else if(a==']' && b!='[') return false;
                else if(a=='}' && b!='{') return false;
            }
        }
        if(ss.isEmpty()) return true;
        else return false;
    }
}