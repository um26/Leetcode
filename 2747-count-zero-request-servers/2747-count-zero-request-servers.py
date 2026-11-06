class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        # sort logs by time
        m = len(logs)
        logs.sort(key = lambda x: x[1])
        mi, ma = logs[0][1], logs[-1][1]
        
        # sort queries by start (ends are sorted too
        # since they are equal window length queries)
        qs = []
        for i, e in enumerate(queries):
            start = max(mi, e - x)
            end = min(ma, e)
            qs.append((start, end, i))
        qs.sort()
        
        ct = Counter()
        ans = [n] * len(qs)
        l = r = 0
        for s, e, x in qs:
            # move right pointer to the [query end], track servers
            while r < m and logs[r][1] <= e:
                idx = logs[r][0]
                ct[idx] += 1
                r += 1
            # move left pointer to [query start - 1], remove servers
            while l < m and logs[l][1] < s:
                idx = logs[l][0]
                if idx in ct:
                    ct[idx] -= 1
                    if not ct[idx]:
                        del ct[idx]
                l += 1
            # update answer
            ans[x] = n - len(ct)
            # terminate if all logs out of the window
            if l == m:
                break
        return ans