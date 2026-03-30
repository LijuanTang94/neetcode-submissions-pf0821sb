class TimeMap:

    def __init__(self):
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        s = ""
        if key not in self.store:
            return s
        l, r = 0, len(self.store[key]) - 1
        while l <= r:
            mid = (l + r) // 2
            if self.store[key][mid][1] <= timestamp:
                s = self.store[key][mid][0]
                l = mid + 1
            else:
                r = mid - 1
        return s
