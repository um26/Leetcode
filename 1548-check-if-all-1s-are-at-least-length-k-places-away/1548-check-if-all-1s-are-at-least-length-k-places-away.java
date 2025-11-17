class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int count=k;
        for(int i=0;i<n;i++){
            if(nums[i]==0) count++;
            else{
                if(count<k) return false;
                count=0;
            }
        }
        return true;
    }
}