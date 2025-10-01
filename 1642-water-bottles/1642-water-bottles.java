class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int B=numBottles, E=numExchange, rem=0,sum=0;
        sum+=B;
        while(B>=E){
            rem=B%E;
            B/=E;
            sum+=B;
            B+=rem;
        }
        return sum;
    }
}