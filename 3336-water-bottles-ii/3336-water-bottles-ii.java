class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int B=numBottles, E=numExchange, sum=numBottles;

        while(B>=E){
            B-=E;
            sum++;
            E++;
            B++;
        }
        return sum;
    }
}