package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), s);
        return res;
    }
    private void backTracking(List<List<String>> res, ArrayList<String> list, String s) {
        if(s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(var i = 0; i<s.length(); i++){
            if(isPalindrome(s.substring(0, i+1))){//[x0-x1-y2-y3] =4 Length
                list.add(s.substring(0, i+1));
                backTracking(res, list, s.substring(i+1));
                list.remove(list.size()-1);
            }

        }
    }
    private boolean isPalindrome(String subString){
        int start = 0;
        int end = subString.length()-1;
        while(end>=start){
            if(subString.charAt(start) != subString.charAt(end)){
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}

/*

    choose what? For this problem, we choose each substring.
    how to explore? For this problem, we do the same thing to the remained string.
    unchoose Do the opposite operation of choose.

Let's take this problem as an example:
1.Define helper(): Usually we need a helper funcition in backtracking problem, to accept more parameters.
2.Parameters: Usually we need the following parameters

    1. The object you are working on:  For this problem is String s.
    2. A start index or an end index which indicate which part you are working on: For this problem, we use substring to indicate the start index.
    3. A step result, to remember current choose and then do unchoose : For this problem, we use List<String> step.
    4. A final result, to remember the final result. Usually when we add, we use 'result.add(new ArrayList<>(step))' instead of 'result.add(step)', since step is reference passed. We will modify step later, so we need to copy it and add the copy to the result;

3.Base case: The base case defines when to add step into result, and when to return.
4.Use for-loop : Usually we need a for loop to iterate though the input String s, so that we can choose all the options.
5.Choose : In this problem, if the substring of s is palindrome, we add it into the step, which means we choose this substring.
6.Explore : In this problem, we want to do the same thing to the remaining substring. So we recursively call our function.
7.Un-Choose : We draw back, remove the chosen substring, in order to try other options
 */

