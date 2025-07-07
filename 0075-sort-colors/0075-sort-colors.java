class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length, low=0, mid=0, high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,mid,low);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,high,mid);
                high--;
            }
        }
    }
        public void swap(int[] nums, int a,int b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
        }

}