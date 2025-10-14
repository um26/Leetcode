class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false;

        for (int i = 0; i <= n - 2 * k; i++) {
            boolean firstInc = true;
            boolean secondInc = true;

            // Check first subarray
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    firstInc = false;
                    break;
                }
            }

            // Check second subarray
            for (int j = i + k; j < i + 2 * k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    secondInc = false;
                    break;
                }
            }

            if (firstInc && secondInc) return true;
        }

        return false;
    }
}