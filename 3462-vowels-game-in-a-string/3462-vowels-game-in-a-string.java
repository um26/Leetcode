class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (isVowel(c)) return true; // Alice wins if there's at least one vowel
        }
        return false; // No vowels means Bob wins
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}