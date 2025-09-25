class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Start from the second last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                int downLeft = triangle.get(row + 1).get(col);
                int downRight = triangle.get(row + 1).get(col + 1);
                int current = triangle.get(row).get(col);
                triangle.get(row).set(col, current + Math.min(downLeft, downRight));
            }
        }
        return triangle.get(0).get(0);
    }
}