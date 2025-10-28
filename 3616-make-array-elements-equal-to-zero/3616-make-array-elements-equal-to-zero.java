class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n]; // sum of nums[0..i-1]
        int[] suffix = new int[n]; // sum of nums[i+1..n-1]

        for (int i = 1; i < n; ++i)
            prefix[i] = prefix[i - 1] + nums[i - 1];

        for (int i = n - 2; i >= 0; --i)
            suffix[i] = suffix[i + 1] + nums[i + 1];

        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) continue; // only start from zero
            if (prefix[i] == suffix[i]) count += 2; // both directions work
            else if (Math.abs(prefix[i] - suffix[i]) == 1) count += 1; // only one direction works
        }

        return count;
    }
}