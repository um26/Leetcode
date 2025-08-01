class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int result=target-nums[i];
            if(hash.containsKey(result)){
                return new int[]{hash.get(result),i};
            }
            hash.put(nums[i],i);
        }

        return new int[]{};

    }
}