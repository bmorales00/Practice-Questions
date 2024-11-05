package com.brianprojects.Leetcode.Heap;

import java.util.*;

public class Twitter {
    public class Tweet{

     private int tweetId;
     private int time;

     public Tweet(){}

     public Tweet(int tweetId, int time){
         this.tweetId = tweetId;
         this.time = time;
     }

     public int getTweetId() {
         return tweetId;
     }
     public int getTime() {
         return time;
     }
    }
    HashMap<Integer, HashSet<Integer>> followerMap;
    HashMap<Integer, List<Tweet>> tweetMap;
    int timeTweetCount;
    public Twitter(){
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        timeTweetCount = -1;
    }
    public void postTweet(int userId, int tweetId){
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new Tweet(tweetId, timeTweetCount--));
    }
    public List<Integer> getNewsFeed(int userId){
        List<Integer> res = new ArrayList<>();
        Queue<Tweet> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Tweet::getTime));

        if(followerMap.containsKey(userId) && !followerMap.get(userId).isEmpty()){
            for(var followedId : followerMap.get(userId)){
                if(tweetMap.containsKey(followedId)){
                    maxHeap.addAll(tweetMap.get(followedId));
                }
            }
        }
        if(tweetMap.containsKey(userId)){
            maxHeap.addAll(tweetMap.get(userId));
        }
        while(!maxHeap.isEmpty() && res.size() <10){
            res.add(maxHeap.poll().getTweetId());
        }
        return res;
    }
    public void follow(int followerId, int followeeId){
        if(!followerMap.containsKey(followerId)){
            followerMap.put(followerId, new HashSet<>());
        }
        followerMap.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId){
        if(followerMap.containsKey(followerId)){
            followerMap.get(followerId).remove(followeeId);
        }
    }
}
