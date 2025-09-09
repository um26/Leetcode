class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hash= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hash.containsKey(s.charAt(i))){
                int a=hash.get(s.charAt(i));
                hash.put(s.charAt(i), a+1);
            }
            else hash.put(s.charAt(i), 1);
        }
        int a=hash.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(a!=hash.get(s.charAt(i))) return false;
        }
        return true;
    }
}