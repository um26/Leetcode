class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] f = new long[n]; // f[i] = earliest time wizard i is free

        for (int j = 0; j < m; ++j) {
            long x = mana[j];
            long now = f[0]; // start brewing potion j at wizard 0

            // Forward pass: compute when wizard n-1 finishes potion j
            for (int i = 1; i < n; ++i) {
                now = Math.max(now + skill[i - 1] * x, f[i]);
            }

            // Update wizard n-1's finish time
            f[n - 1] = now + skill[n - 1] * x;

            // Backward pass: update other wizards' finish times
            for (int i = n - 2; i >= 0; --i) {
                f[i] = f[i + 1] - skill[i + 1] * x;
            }
        }

        return f[n - 1];
    }
}