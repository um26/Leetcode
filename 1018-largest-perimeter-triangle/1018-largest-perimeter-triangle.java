class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i], b = nums[i - 1], c = nums[i - 2];
            if (b + c > a) {
                return a + b + c; // Valid triangle found
            }
        }
        return 0; // No valid triangle
    }
}