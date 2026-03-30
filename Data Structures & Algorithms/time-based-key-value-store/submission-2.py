class TimeMap:

    def __init__(self):
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append((value,timestamp))
    

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.store:
            return ""
        l, r = 0, len(self.store[key]) - 1
        s = ""
        while l <= r:
            mid = (l + r) // 2
            if self.store[key][mid][1] <= timestamp:
                l = mid + 1
                s = self.store[key][mid][0]
            else:
                r = mid - 1
        return s

