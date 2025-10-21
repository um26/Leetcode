import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] a, int k, int op) {
        int max = Arrays.stream(a).max().getAsInt();
        int n = max + k + 2;

        int[] cnt = new int[n];
        for (int x : a) cnt[x]++;

        int[] sum = new int[n];
        sum[0] = cnt[0];
        for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + cnt[i];

        int res = 0;
        for (int x = 0; x < n; x++) {
            if (cnt[x] == 0 && op == 0) continue;

            int lo = Math.max(0, x - k);
            int hi = Math.min(n - 1, x + k);
            int total = sum[hi] - (lo > 0 ? sum[lo - 1] : 0);
            int extra = total - cnt[x];
            int freq = cnt[x] + Math.min(op, extra);

            res = Math.max(res, freq);
        }

        return res;
    }
}