class Solution {
    private int[] seg;
    private int m;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        m = baskets.length;
        seg = new int[4 * m];
        build(baskets, 0, m - 1, 1);

        int unplaced = 0;
        for (int fruit : fruits) {
            int idx = queryAndUse(fruit, 0, m - 1, 1);
            if (idx == -1) unplaced++;
        }
        return unplaced;
    }

    private void build(int[] baskets, int lo, int hi, int idx) {
        if (lo == hi) {
            seg[idx] = baskets[lo];
        } else {
            int mid = (lo + hi) / 2;
            build(baskets, lo, mid, 2 * idx);
            build(baskets, mid + 1, hi, 2 * idx + 1);
            seg[idx] = Math.max(seg[2 * idx], seg[2 * idx + 1]);
        }
    }

    private int queryAndUse(int target, int lo, int hi, int idx) {
        if (seg[idx] < target) return -1;
        if (lo == hi) {
            seg[idx] = -1;  // mark used
            return lo;
        }
        int mid = (lo + hi) / 2;
        int res;
        if (seg[2 * idx] >= target) {
            res = queryAndUse(target, lo, mid, 2 * idx);
        } else {
            res = queryAndUse(target, mid + 1, hi, 2 * idx + 1);
        }
        seg[idx] = Math.max(seg[2 * idx], seg[2 * idx + 1]);
        return res;
    }
}
