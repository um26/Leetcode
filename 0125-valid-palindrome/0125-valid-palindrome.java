class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=stack.pop()){
                return false;
            }
        }
        return true;
    }
}