class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash= new HashMap<>();
        int[] ans= new int[2];

        for(int i=0;i<nums.length;i++){
            hash.put(target-nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(nums[i]) && i!= hash.get(nums[i])){
                ans[0]=i;
                ans[1]= hash.get(nums[i]);
            }
        }
        return ans;
    }
}