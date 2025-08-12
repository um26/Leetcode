class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        // Precompute all powers i^x <= n
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; ; i++) {
            long val = 1;
            for (int j = 0; j < x; j++) {
                val *= i;
            }
            if (val > n) break;
            powers.add((int) val);
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; // base case: 1 way to make sum 0

        // Subset sum count
        for (int p : powers) {
            for (int sum = n; sum >= p; sum--) {
                dp[sum] = (dp[sum] + dp[sum - p]) % MOD;
            }
        }

        return dp[n];
    }
}
