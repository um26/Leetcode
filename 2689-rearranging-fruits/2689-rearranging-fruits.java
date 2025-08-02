public class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = basket1.length;
        int minFruit = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            countMap.put(basket1[i], countMap.getOrDefault(basket1[i], 0) + 1);
            countMap.put(basket2[i], countMap.getOrDefault(basket2[i], 0) - 1);
            minFruit = Math.min(minFruit, Math.min(basket1[i], basket2[i]));
        }

        List<Integer> surplus = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int val = entry.getValue();
            if (val % 2 != 0) return -1;  // Impossible to make equal
            for (int i = 0; i < Math.abs(val) / 2; i++) {
                surplus.add(entry.getKey());
            }
        }

        Collections.sort(surplus);

        long cost = 0;
        for (int i = 0; i < surplus.size() / 2; i++) {
            cost += Math.min(surplus.get(i), 2 * minFruit);
        }

        return cost;
    }
}
