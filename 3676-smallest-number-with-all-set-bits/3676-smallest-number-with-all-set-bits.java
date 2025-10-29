class Solution {
    public int smallestNumber(int n) {
        int count=0;
        while(n>=1){
            count++;
            n/=2;
        }
        return (int) Math.pow(2, count) -1;
    }
}