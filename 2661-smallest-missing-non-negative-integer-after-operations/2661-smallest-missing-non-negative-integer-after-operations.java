import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            int mod = ((num % value) + value) % value; // handle negative mods
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
        }

        int i = 0;
        while (true) {
            int mod = i % value;
            if (!freq.containsKey(mod) || freq.get(mod) == 0) {
                return i;
            }
            freq.put(mod, freq.get(mod) - 1);
            i++;
        }
    }
}