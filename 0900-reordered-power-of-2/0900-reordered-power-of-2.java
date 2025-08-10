class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Precompute all powers of 2 digit signatures
        Set<String> powerSignatures = new HashSet<>();
        for (int i = 0; i < 31; i++) { // 2^0 to 2^30 fits in int
            powerSignatures.add(countDigits(1 << i));
        }
        
        // Check if n's signature matches any power of 2 signature
        return powerSignatures.contains(countDigits(n));
    }
    
    // Helper to count digits and return sorted string signature
    private String countDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
