class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length, a=0, b=0,count=0;
        while(b<n){
            if(nums[b]==0){
                b++;
                count++;
            }
            else if(nums[b]!=0){
                int temp=nums[a];
                nums[a]=nums[b];
                nums[b]=temp;
                a++;
                b++;
            }
        }
        for(int i=n-count;i<n;i++){
            nums[i]=0;
        }
    }
}