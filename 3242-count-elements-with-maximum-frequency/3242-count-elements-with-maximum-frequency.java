class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hash= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            hash.put(nums[i], hash.getOrDefault(nums[i],0) +1);
        }
        int max=1;
        for(int i=0;i<nums.length;i++){
            int cur= hash.get(nums[i]);
            if(cur>max) max=cur;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int cur= hash.get(nums[i]);
            if(cur==max) sum++;
        }
        return sum;
    }
}