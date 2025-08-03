public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int total = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            while (left <= right && !canReachWithinK(fruits, startPos, left, right, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }


    private boolean canReachWithinK(int[][] fruits, int startPos, int left, int right, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        // Two options: go to left then right, or right then left
        int option1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int option2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(option1, option2) <= k;
    }
}
