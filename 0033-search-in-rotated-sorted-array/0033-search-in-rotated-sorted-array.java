class Solution {
    public int search(int[] nums, int target) {
        int mid=-1;
        int l=nums.length;
        int low=0, high=l-1;
        if(nums.length==0) return mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if(target==nums[mid]) return mid;
            if(nums[low]<=nums[high]){
                if(target<=nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else if(nums[low]<=nums[mid]){
                if(target<=nums[mid] && target>=nums[low]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(target<=nums[high] && target>=nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}