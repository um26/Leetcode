class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevSorted = "";

        for (String word : words) {
            String sorted = sortString(word);
            if (!sorted.equals(prevSorted)) {
                result.add(word);
                prevSorted = sorted;
            }
        }

        return result;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}