package com.brianprojects.Leetcode.BinarySearch;

public class GuessNumberHigherOrLower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */


    //TIme Complexity: O(log n) | SPace Complexity: O(1)

//    public int guessNumber(int n){
//        int start = 1;
//        int end = n;
//        while(start<end){
//            int mid = start+(end-start)/2;
//            int res = guess(mid);
//            if(res == 0){
//                return mid;
//            }
//            else if(res == 1){
//                start = mid+1;
//            }
//            else{
//                end = mid;
//            }
//        }
//        return start;
//    }
}
