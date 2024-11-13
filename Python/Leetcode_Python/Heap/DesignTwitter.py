import heapq
from typing import List


class Twitter:
    def __init__(self) -> None:
        self.count = 0
        self.followMapper = dict()  # {followerId:[followeeId ... ]}
        self.tweetMapper = dict()  # {userId : [count ... ]}
        self.timeStamp = dict()  # Timestamp {count : tweetId}

    def getNewsFeed(self, userId: int) -> List[int]:
        if userId not in self.tweetMapper:
            self.tweetMapper[userId] = list()
        if userId not in self.followMapper:
            self.followMapper[userId] = set()

        heap = []
        res = []
        maxFeedSize = 10

        for count in self.tweetMapper[userId]:
            heapq.heappush(heap, count)

        followees = self.followMapper[userId]
        for followee in followees:
            if followee not in self.tweetMapper:
                self.tweetMapper[followee] = list()
            tweets = self.tweetMapper[followee]
            for tweet in tweets:
                heapq.heappush(heap, tweet)

        while heap and len(res) < maxFeedSize:
            msr = heapq.heappop(heap)
            res.append(self.timeStamp[msr])

        return res

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.tweetMapper:
            self.tweetMapper[userId] = list()

        self.tweetMapper[userId].append(self.count)
        self.timeStamp[self.count] = tweetId
        self.count -= 1

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.followMapper:
            self.followMapper[followerId] = set()
        if followeeId not in self.followMapper:
            self.followMapper[followeeId] = set()

        self.followMapper[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.followMapper:
            return

        if followeeId not in self.followMapper[followerId]:
            return

        self.followMapper[followerId].discard(followeeId)


t = Twitter()
t.follow(1, 5)
print(t.getNewsFeed(1))
