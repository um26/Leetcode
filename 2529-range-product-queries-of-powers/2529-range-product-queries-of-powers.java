class Solution {
    static final int MOD = 1_000_000_007;
    
    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Build powers array
        java.util.List<Integer> list = new java.util.ArrayList<>();
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                list.add(1 << bit); // 2^bit
            }
            bit++;
            n >>= 1;
        }
        
        // Step 2: prefix product array
        int m = list.size();
        long[] prefix = new long[m + 1];
        prefix[0] = 1;
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = (prefix[i] * list.get(i)) % MOD;
        }
        
        // Step 3: Answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long num = prefix[r + 1];
            long den = prefix[l];
            long inv = modPow(den, MOD - 2); // modular inverse
            ans[i] = (int)((num * inv) % MOD);
        }
        
        return ans;
    }
    
    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
