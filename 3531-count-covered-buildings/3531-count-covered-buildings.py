from collections import defaultdict
from math import inf
class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        n = len(buildings)
        dmn = defaultdict(lambda: inf)
        dmx = defaultdict(lambda: -inf)

        # For each x → track min y and max y
        ymn = defaultdict(lambda: inf)
        ymx = defaultdict(lambda: -inf)

        # ---- First pass: compute mins and maxs ----
        for x, y in buildings:
            if x < dmn[y]: dmn[y] = x
            if x > dmx[y]: dmx[y] = x

            if y < ymn[x]: ymn[x] = y
            if y > ymx[x]: ymx[x] = y

        # ---- Second pass: count interior points ----
        c = 0
        for x, y in buildings:
            if dmn[y] < x < dmx[y] and ymn[x] < y < ymx[x]:
                c += 1

        return c