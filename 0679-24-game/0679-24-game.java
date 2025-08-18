class Solution {
    private static final double EPS = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        // start with doubles to avoid integer division
        java.util.List<Double> nums = new java.util.ArrayList<>(4);
        for (int x : cards) nums.add((double) x);
        return dfs(nums);
    }

    private boolean dfs(java.util.List<Double> nums) {
        // if only one number left, check if it's (approximately) 24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPS;
        }

        int n = nums.size();

        // Try every unordered pair (i, j) with i != j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // Build the list of remaining numbers after using i and j
                java.util.List<Double> next = new java.util.ArrayList<>(n - 1);
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                double a = nums.get(i);
                double b = nums.get(j);

                // For commutative ops (+, *), avoid duplicate work by enforcing i < j
                // We’ll add those results only when i < j.
                if (i < j) {
                    // a + b
                    next.add(a + b);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);

                    // a * b
                    next.add(a * b);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }

                // a - b
                next.add(a - b);
                if (dfs(next)) return true;
                next.remove(next.size() - 1);

                // b - a
                next.add(b - a);
                if (dfs(next)) return true;
                next.remove(next.size() - 1);

                // a / b (if b != 0)
                if (Math.abs(b) > EPS) {
                    next.add(a / b);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }

                // b / a (if a != 0)
                if (Math.abs(a) > EPS) {
                    next.add(b / a);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}
