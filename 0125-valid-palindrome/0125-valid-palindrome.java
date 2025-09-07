class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        String ss= s.replaceAll("[^a-zA-Z0-9]", "");
        Stack<String> stack=new Stack<>();
        // for(int i=0;i<s.length();i++){
        //     Stack.push(s.charAt(i));
        // }
        for(int i=0;i<ss.length()/2;i++){
            if(ss.charAt(i)!=ss.charAt(ss.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}