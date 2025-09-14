import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelMasked = new HashMap<>();

        for (String word : wordlist) {
            exactMatch.add(word);
            String lower = word.toLowerCase();
            String masked = maskVowels(lower);

            caseInsensitive.putIfAbsent(lower, word);
            vowelMasked.putIfAbsent(masked, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactMatch.contains(query)) {
                result[i] = query;
            } else {
                String lower = query.toLowerCase();
                String masked = maskVowels(lower);
                if (caseInsensitive.containsKey(lower)) {
                    result[i] = caseInsensitive.get(lower);
                } else if (vowelMasked.containsKey(masked)) {
                    result[i] = vowelMasked.get(masked);
                } else {
                    result[i] = "";
                }
            }
        }
        return result;
    }

    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}