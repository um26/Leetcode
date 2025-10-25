class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = 0;

        // Sum for complete weeks
        // Each week starts with +1 more than the previous
        // Week 1: 28, Week 2: 35, Week 3: 42, ...
        // Formula for week i: 7 * i + sum of 0 to 6 = 7 * i + 21 = 7 * i + 21
        // So total for week i = 7 * i + 21
        // But we can simplify using arithmetic series:
        total += 7 * weeks * (weeks - 1) / 2 + 28 * weeks;

        // Sum for remaining days in the last (incomplete) week
        // Starts with (weeks + 1) on Monday
        for (int i = 0; i < days; i++) {
            total += weeks + 1 + i;
        }

        return total;
    }
}