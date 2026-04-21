from collections import defaultdict, Counter

class Solution:
    def minimumHammingDistance(self, source, target, allowedSwaps):
        parent = list(range(len(source)))

        # Find with path compression
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        # Union
        def union(x, y):
            px, py = find(x), find(y)
            if px != py:
                parent[py] = px

        # Step 1: Build connected components
        for a, b in allowedSwaps:
            union(a, b)

        # Step 2: Group indices
        groups = defaultdict(list)
        for i in range(len(source)):
            root = find(i)
            groups[root].append(i)

        # Step 3: Compute mismatch
        res = 0
        for indices in groups.values():
            count = Counter()
            
            # Count source values
            for i in indices:
                count[source[i]] += 1
            
            # Match with target
            for i in indices:
                if count[target[i]] > 0:
                    count[target[i]] -= 1
                else:
                    res += 1

        return res