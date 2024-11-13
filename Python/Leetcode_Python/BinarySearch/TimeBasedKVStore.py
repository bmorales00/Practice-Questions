# Time Complexity: O(n log n) || Space Complexity: O(n)
class TimeMap:
    def __init__(self) -> None:
        self.timeBasedMapper = dict()

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.timeBasedMapper:
            self.timeBasedMapper[key] = [[0], [""]]
        kv = self.timeBasedMapper.get(key)
        kv[0].append(timestamp)
        kv[1].append(value)

    def get(self, key: str, value: str, timestamp: int) -> str:
        if key not in self.timeBasedMapper or len(self.timeBasedMapper[key][0]) == 1:
            return ""

        kv = self.timeBasedMapper.get(key)
        timeList = kv[0]
        wordList = kv[1]

        if timeList[-1] <= timestamp:
            return wordList[-1]

        start = 1
        end = len(timeList) - 1

        val = 1
        while start <= end:
            mid = (end + start) // 2

            if timeList[mid] <= timestamp:
                val = mid
                start = mid + 1
            else:
                end = mid - 1

        if timeList[val] > timestamp:
            return wordList[0]

        return wordList[val]
