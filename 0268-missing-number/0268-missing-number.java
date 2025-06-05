class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int sumton=n*(n+1)/2;
        int sumofnums=0;
        for(int i=0;i<n;i++){
            sumofnums+= nums[i];
        }
        return sumton - sumofnums;
    }
}