class Solution:
    def minSumSquareDiff(self, nums1: list[int], nums2: list[int], k1: int, k2: int) -> int:
        diff2freq = defaultdict(int)
        total = 0
        k = k1 + k2
        for i in range(len(nums1)):
            diff = abs(nums1[i] - nums2[i])
            diff2freq[diff] += 1
            total += diff
        if total <= k:
            return 0
        heap = []
        for diff, count in diff2freq.items():
            heap.append((diff, count))
        heapq.heapify_max(heap)
        while k:
            diff, freq = heapq.heappop_max(heap)
            if diff <= 0:
                break
            reduceAll = k // freq
            extras = k % freq
            reg = freq - extras
            larger = diff - reduceAll
            smaller = diff - reduceAll - 1
            if not heap:
                heap = [(max(larger, 0), reg), (max(smaller, 0), extras)]
                break
            nextDiff, nextFreq = heap[0]
            diffdiff = diff - nextDiff
            if diffdiff > reduceAll:
                heap.append((smaller, extras))
                heap.append((larger, reg))
                break
            k -= diffdiff * freq
            heapq.heappush_max(heap, (heapq.heappop_max(heap)[0], nextFreq + freq))     
        return sum(diff * diff * freq for diff, freq in heap if diff > 0)