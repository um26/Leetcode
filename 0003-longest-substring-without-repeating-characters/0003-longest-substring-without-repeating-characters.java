class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash= new HashMap<>();
        int maxcount=0;
        int n=s.length();
        int i=0;
        for(int j=0;j<n;j++){
            char current = s.charAt(j);

            if(hash.containsKey(current) && hash.get(current)>=i){
                i= hash.get(current)+1;
            }
            hash.put(current,j);

            maxcount=Math.max(maxcount, j-i+1);
        }
        return maxcount;
    }
}