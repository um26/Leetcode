class Solution {
    public int numSub(String s) {
        long count = 0, result = 0;
        int mod = 1_000_000_007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                result += count * (count + 1) / 2;
                count = 0;
            }
        }

        // Add the last block if it ends with '1'
        result += count * (count + 1) / 2;

        return (int)(result % mod);
    }
}