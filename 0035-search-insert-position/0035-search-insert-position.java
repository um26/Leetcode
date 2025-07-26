class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=nums.length;
        int low=0, high=l-1;
        if(target<nums[0]) return 0;
        if(target>nums[l-1]) return l;
        int temp=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]) return mid;
            if(target<nums[mid]){
                high=mid-1;
            }
            else{
                temp=mid+1;
                low=mid+1;
            }
        }
        return temp;
    }
}