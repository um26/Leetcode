import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String result = s;

        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(result) < 0) {
                result = curr;
            }

            // Operation 1: Add 'a' to all digits at odd indices
            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String added = new String(chars);
            if (visited.add(added)) {
                queue.offer(added);
            }

            // Operation 2: Rotate right by 'b' positions
            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }

        return result;
    }
}