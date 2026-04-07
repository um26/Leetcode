class Robot:
    def __init__(self, width: int, height: int):
        self.width = width
        self.height = height
        self.dist  = 0
        self.per = 2 * (width + height) - 4
        self.notMoved = True

    def step(self, num: int) -> None:
        self.notMoved = False
        self.dist = (self.dist + num) %self.per 
        return 

    def getPos(self) -> list[int]:
        p, d, w, h = self.per, self.dist, self.width, self.height
        if   d == 0            : return [0, 0]
        elif d <  w            : return [d, 0]
        elif d <  w  + h - 1   : return [w - 1, d - w + 1]
        elif d <  2 * w + h-2  : return [p - h - d + 1, h -1 ]
        elif d                 : return [0, p - d]
        
    def getDir(self) -> str:
        if self.notMoved : return "East"
        
        w, h = self.width, self.height
        if   self.dist == 0            : return "South"
        elif self.dist < w             : return "East"
        elif self.dist < w + h - 1     : return "North"
        elif self.dist < 2 * w + h - 2 : return "West"
        elif self.dist                 : return "South"