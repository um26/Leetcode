class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++)
        //     {
        //         if(nums[i]+nums[j]==target)
        //         {
        //             return new int[]{i, j};
        //         }
        //     }
        int i=0;
        int j=nums.length -1;
        while(i<nums.length && j>0){
            if(nums[i]+nums[j]==target){
                return new int[]{i, j};
            }
            else{
                i++; j--;
            }
            
        }
    return null;}
}