class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int n=nums.length;
        int j=1;
        int count=1;
        while(j<n){
            if(nums[i]== nums[j]){
                j++;
            }
            else{
                i++;
                nums[i]=nums[j];
                j++;
                count++;
            }
        }
        return count;
    }
}