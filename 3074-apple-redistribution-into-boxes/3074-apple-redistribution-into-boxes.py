class Solution:
    def minimumBoxes(self, apple: list[int], capacity: list[int]) -> int:
        total = 0
        for x in apple:
            total += x

        capacity.sort()
        boxes = 0
        cap = 0
        for i in range(len(capacity) - 1, -1, -1):
            cap += capacity[i]
            boxes += 1
            if cap >= total:
                break

        return boxes