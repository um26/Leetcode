class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int temp=-1;
        int low=0, high=n-1;
        if(nums[0]>target) return 0;
        if(nums[n-1]<target) return n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]> target){
                high=mid-1;
            }
            else{
                temp=mid+1;
                low=mid+1;
            }
        } return temp;
    }
}