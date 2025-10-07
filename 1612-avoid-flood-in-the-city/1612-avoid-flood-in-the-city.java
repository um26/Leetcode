import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Map<Integer, Integer> lakeToLastRainDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                result[i] = 1; // default dry any lake
            } else {
                int lake = rains[i];
                result[i] = -1; // raining day

                if (lakeToLastRainDay.containsKey(lake)) {
                    int lastRainDay = lakeToLastRainDay.get(lake);
                    Integer dryDay = dryDays.higher(lastRainDay);
                    if (dryDay == null) return new int[0]; // flood is unavoidable

                    result[dryDay] = lake; // dry this lake on dryDay
                    dryDays.remove(dryDay);
                }

                lakeToLastRainDay.put(lake, i);
            }
        }

        return result;
    }
}