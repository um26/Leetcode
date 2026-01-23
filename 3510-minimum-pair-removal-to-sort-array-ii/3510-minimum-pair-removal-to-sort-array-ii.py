class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
      
        N = len(nums)

        # Doubly linked list: idx -> (prevIdx, nextIdx)
        linked = {N - 1: (N - 2, None)}

        # Min-heap of (pairSum, leftIndex)
        heap = []

        # Indices i where nums[i] > nums[i+1]
        remove = set()

        # Initialize heap, linked list, and descending positions
        for i, (prev, curr) in enumerate(zip(nums, nums[1:])):

            if i == 0:
                linked[i] = (None, i + 1)
            else:
                linked[i] = (i - 1, i + 1)

            if curr < prev:
                remove.add(i)

            heappush(heap, (prev + curr, i))

        ops = 0

        # Continue until array becomes non-decreasing
        while heap and remove:
      
            lowest, idx = heappop(heap)
            prevIdx, nextIdx = linked[idx]

            # ---- Skip stale heap entries ----
            # Element already removed
            if nums[idx] is None:
                continue

            # Pair no longer valid or idx is last element
            if nextIdx is None or lowest != nums[idx] + nums[nextIdx]:
                continue

            # ---- Perform merge ----
            remove.discard(idx)
            ops += 1

            # Replace nums[idx] with merged value
            nums[idx] = lowest

            # ---- Update left neighbor ----
            if prevIdx is not None:
                prevPrevIdx, _ = linked[prevIdx]
                linked[prevIdx] = (prevPrevIdx, idx)

                if nums[prevIdx] > lowest:
                    remove.add(prevIdx)
                else:
                    remove.discard(prevIdx)

                heappush(heap, (nums[prevIdx] + lowest, prevIdx))

            # ---- Update right neighbor ----
            if nextIdx is not None:
                nums[nextIdx] = None
                remove.discard(nextIdx)

                _, nextNextIdx = linked[nextIdx]
                linked[idx] = (prevIdx, nextNextIdx)

                if nextNextIdx is not None:
                    linked[nextNextIdx] = (idx, linked[nextNextIdx][1])

                    if lowest > nums[nextNextIdx]:
                        remove.add(idx)

                    heappush(heap, (lowest + nums[nextNextIdx], idx))

        return ops
            