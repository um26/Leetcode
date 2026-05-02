class Solution:
    def rotatedDigits(self, n: int) -> int:
        s = str(n)
        memo = {}

        valid_same = {0, 1, 8}
        valid_diff = {2, 5, 6, 9}

        def dp(pos, tight, hasChanged):
            if pos == len(s):
                return 1 if hasChanged else 0

            if (pos, tight, hasChanged) in memo:
                return memo[(pos, tight, hasChanged)]

            limit = int(s[pos]) if tight else 9
            res = 0

            for d in range(0, limit + 1):
                if d in {3, 4, 7}:
                    continue

                new_tight = tight and (d == limit)
                new_changed = hasChanged or (d in valid_diff)

                res += dp(pos + 1, new_tight, new_changed)

            memo[(pos, tight, hasChanged)] = res
            return res

        return dp(0, True, False)

