class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int end=n-1;
        int start=0;
        while(start<=end){
            if(nums[start]!=val) start++;
            else if(nums[end]==val) end--;
            else if(nums[start]==val && nums[end]!=val){
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
        }
        return start;
    }
}