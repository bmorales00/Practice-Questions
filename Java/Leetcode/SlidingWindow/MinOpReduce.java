package com.brianprojects.Leetcode.SlidingWindow;

public class MinOpReduce {
    public int minOperations(int[] nums , int x){
        if(nums == null){return -1;}

        int l = -1;
        int r = nums.length;
        int lCount =0;
        int rCount = 0;
        int op = -1;
        while((nums[l+1]+lCount) + (nums[r-1]+rCount)<=x && l!=r){
            lCount+=nums[++l];
            rCount+=nums[--r];
        }
        int i =l;
        int temp = lCount;
        while(i+1<r && (nums[i+1]+temp) <=x){
            if(nums[i+1]+temp == x){op = op==-1?i+1:Math.min(op, i+1);}
            if(nums[i+1] + temp + rCount == x){op = op==-1?i+1+(nums.length-r):Math.min(op, i+1+(nums.length-r));}
            temp+=nums[++i];
        }
        i = r;
        temp = rCount;
        while(i-1>l && (nums[i-1]+temp) <=x){
            if(nums[i-1]+temp == x){op = op ==-1?nums.length-i:Math.min(op, nums.length-i);}
            if(nums[i-1]+temp+lCount == x){op = op==-1?(nums.length-i+1)+(l+1):Math.min(op, (nums.length-i+1)+(l+1));}
            temp+=nums[--i];
        }
        return op;
    }


}
/*
while(l<r && ){

        }
        while(nums[r-1]+rCount<=x&& l<r-1){
            rCount+=nums[--r];
            int i = l+1;int j = nums.length-r;
            if(rCount == x){return j;}
            else if(lCount+rCount == x){return i+j;}
        }
        return -1;
 */