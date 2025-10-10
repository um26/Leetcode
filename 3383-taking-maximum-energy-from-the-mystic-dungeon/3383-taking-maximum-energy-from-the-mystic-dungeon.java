class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int maxEnergy = Integer.MIN_VALUE;

        // Traverse from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // If i + k is out of bounds, we can't jump further
            if (i + k >= n) {
                dp[i] = energy[i];
            } else {
                dp[i] = energy[i] + dp[i + k];
            }
            maxEnergy = Math.max(maxEnergy, dp[i]);
        }

        return maxEnergy;
    }
}