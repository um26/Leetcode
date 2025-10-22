import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int maxFreq = 1;

        for (int i = 0; i < nums.length; i++) {
            maxFreq = Math.max(maxFreq, getFrequency(nums, nums[i], k, numOperations));
            maxFreq = Math.max(maxFreq, getFrequency(nums, nums[i] - k, k, numOperations));
            maxFreq = Math.max(maxFreq, getFrequency(nums, nums[i] + k, k, numOperations));
        }

        return maxFreq;
    }

    private int getFrequency(int[] nums, int target, int k, int maxOps) {
        long t = k;
        long n = target;

        int left = lowerBound(nums, n);
        int right = upperBound(nums, n);
        int leftRange = lowerBound(nums, n - t);
        int rightRange = upperBound(nums, n + t);

        int outsideCount = (rightRange - right) + (left - leftRange);
        int withinCount = right - left;

        return Math.min(maxOps, outsideCount) + withinCount;
    }

    private int lowerBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int upperBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}