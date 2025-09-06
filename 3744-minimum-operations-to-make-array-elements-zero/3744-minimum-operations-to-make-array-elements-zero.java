class Solution {
    public long minOperations(int[][] queries) {
        long total = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            total += (getOperations(r) - getOperations(l - 1) + 1) / 2;
        }
        return total;
    }

    private long getOperations(int n) {
        long res = 0;
        int ops = 0;
        for (int powerOfFour = 1; powerOfFour <= n; powerOfFour *= 4) {
            int left = powerOfFour;
            int right = Math.min(n, powerOfFour * 4 - 1);
            res += (long)(right - left + 1) * ++ops;
        }
        return res;
    }
}
