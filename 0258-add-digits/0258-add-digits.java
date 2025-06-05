class Solution {
    public int addDigits(int num) {
        int sum=0;
        for(int i=num;i>0;i/=10){
            sum+= i%10;
            if(sum>9){
                sum= sum/10+ sum%10;
            }
        }
        return sum;
    }
}