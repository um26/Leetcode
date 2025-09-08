class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (noZero(a) && noZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{}; // This line will not be reached based on the problem constraints
    }

    private boolean noZero(int num) {
        String s = String.valueOf(num);
        return !s.contains("0");
    }
}