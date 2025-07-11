class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int odd=0,even=n-1;
        while(odd<=even){
            if(nums[odd]%2 != 0 && nums[even]%2==0){
                nums[odd]=nums[odd]+nums[even];
                nums[even]=nums[odd]-nums[even];
                nums[odd]=nums[odd]-nums[even];
                odd++;
                even--;
            }
            else if(nums[odd]%2==0) odd++;
            else if(nums[even]%2!=0) even--; 
        }
        return nums;
    }
}