class Solution:
    def pathExistenceQueries(
        self,
        n: int,
        nums: List[int],
        maxDiff: int,
        queries: List[List[int]]
    ) -> List[int]:

        # Sort nodes according to their nums value.
        ordered_nodes = sorted(range(n), key=lambda node: nums[node])

        values = [nums[node] for node in ordered_nodes]

        # position[node] = node's index in the sorted array.
        position = [0] * n
        for sorted_index, node in enumerate(ordered_nodes):
            position[node] = sorted_index

        # component[i] = connected-component ID of sorted position i.
        component = [0] * n
        component_id = 0

        for i in range(1, n):
            if values[i] - values[i - 1] > maxDiff:
                component_id += 1

            component[i] = component_id

        # farthest[i] = farthest sorted position reachable from i
        # using one edge and moving to the right.
        farthest = [0] * n
        right = 0

        for left in range(n):
            right = max(right, left)

            while (
                right + 1 < n
                and values[right + 1] - values[left] <= maxDiff
            ):
                right += 1

            farthest[left] = right

        # Binary-lifting table:
        # jump[level][i] is the position reached after 2^level jumps.
        LOG = max(1, n.bit_length())
        jump = [[0] * n for _ in range(LOG)]

        jump[0] = farthest

        for level in range(1, LOG):
            previous = jump[level - 1]
            current = jump[level]

            for i in range(n):
                current[i] = previous[previous[i]]

        answer = []

        for u, v in queries:
            left = position[u]
            right = position[v]

            if left > right:
                left, right = right, left

            # The distance from a node to itself is 0.
            if left == right:
                answer.append(0)
                continue

            # Nodes in different components are unreachable.
            if component[left] != component[right]:
                answer.append(-1)
                continue

            current = left
            distance = 0

            # Take the largest possible groups of jumps while
            # staying strictly before the destination.
            for level in range(LOG - 1, -1, -1):
                next_position = jump[level][current]

                if next_position < right:
                    current = next_position
                    distance += 1 << level

            # One final jump reaches or passes the destination.
            answer.append(distance + 1)

        return answer