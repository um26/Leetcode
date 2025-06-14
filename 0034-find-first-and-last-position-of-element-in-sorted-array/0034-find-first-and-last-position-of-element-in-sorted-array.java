class Solution {
    public int[] searchRange(int[] nums, int target) {
        int Firstoccur= searchLeft(nums,target);
        int Lastoccur= searchRight(nums,target);
        int result[]= new int[2];
        result[0]=Firstoccur;
        result[1]=Lastoccur;
        return result;
    }

    public int searchLeft(int[] nums, int target){
        int low=0;
        int high=nums.length-1; 
        int Firstoccur=-1; 
            while(high>=low){
                int mid=low+(high-low)/2;
                if(target==nums[mid]){
                    Firstoccur=mid;
                    high=mid-1;
                }
                else if(target<nums[mid]){
                    high=mid-1;
                }
                else if(target>nums[mid]){
                    low=mid+1;
                }
            }
            return Firstoccur;
        }

        public int searchRight(int[] nums, int target){
            int low=0;
            int high=nums.length-1;
            int Lastoccur=-1;
            while(high>=low){
                int mid=low+(high-low)/2;
                if(target==nums[mid]){
                    Lastoccur=mid;
                    low=mid+1;
                }
                else if(target<nums[mid]){
                    high=mid-1;
                }
                else if(target>nums[mid]){
                    low=mid+1;
                }
            }
            return Lastoccur;
        }
}