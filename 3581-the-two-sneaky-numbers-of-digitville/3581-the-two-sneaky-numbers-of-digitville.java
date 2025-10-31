import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 2) {
                result.add(entry.getKey());
                if (result.size() == 2) break;
            }
        }

        return new int[]{result.get(0), result.get(1)};
    }
}