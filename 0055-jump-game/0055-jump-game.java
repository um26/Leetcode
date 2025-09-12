class Solution {
    public boolean canJump(int[] nums) {
        int l=nums.length-1;
        if(nums[0]==l) return true;
        int max=0;
        for(int i=0;i<l+1;i++){
            if(i>max) return false;
            else{
                max=Math.max(max,i+nums[i]);
            }
        }
        return true;
    }
}