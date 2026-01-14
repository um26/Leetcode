class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        events = []
        for x, y, b in squares:
            events.append((y, 1, x, x + b))         # open
            events.append((y + b, 0, x, x + b))    # close
        events.sort()
        xStack, areas = [], []
        prev_y, total = events[0][0], 0

        def xDimension(stack):
            # need to control the overlap on x-axis
            stack.sort()
            width, end = 0, float('-inf')
            for a, b in stack:
                if a > end:
                    # squares do not overlap
                    width += b - a
                    end = b
                elif b > end:
                    # squares overlap partially
                    width += b - end
                    end = b
                # else squares totally overlap
            return width

        for y, typ, x1, x2 in events:
            # this is a new event (new square or end square)
            if y > prev_y and xStack:
                height = y - prev_y
                # need to control the overlap on x-axis
                width = xDimension(xStack)
                areas.append((prev_y, height, width))
                total += height * width
            if typ:
                xStack.append((x1, x2)) # add new square
            else:
                xStack.remove((x1, x2)) # remove square
            prev_y = y

        currArea, half = 0, total / 2
        # this is the list of every items take only one time
        # so they are rectangles to add and to check
        for y, height, width in areas:
            if currArea + height * width >= half:
                return y + (half - currArea) / width
            currArea += height * width
        return 0.0        