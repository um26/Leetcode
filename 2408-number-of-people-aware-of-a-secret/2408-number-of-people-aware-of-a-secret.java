class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1]; // dp[i] = number of people who learn the secret on day i
        dp[1] = 1;

        long sharing = 0; // number of people who can share the secret
        for (int day = 2; day <= n; day++) {
            // People who start sharing today
            if (day - delay >= 1) {
                sharing = (sharing + dp[day - delay]) % MOD;
            }
            // People who forget today
            if (day - forget >= 1) {
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = (int) sharing;
        }

        // Sum up people who still remember the secret on day n
        long total = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            total = (total + dp[day]) % MOD;
        }

        return (int) total;
    }
}
