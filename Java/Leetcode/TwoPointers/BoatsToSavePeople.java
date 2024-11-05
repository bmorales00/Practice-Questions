package com.brianprojects.Leetcode.TwoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoatsToSavePeople {
    public int numRescueBoats(List<Integer> people, int limit){
        if(people == null){
            return 0;
        }
        if(people.size() == 1 && people.get(0) > limit){
            return 0;
        }
        if(people.size() == 1 && people.get(0) < limit){
            return 1;
        }
        Collections.sort(people);

        int slow = 0;
        int fast = 1;
        int nums = people.get(slow);
        int count =0;

        while(slow< people.size() && fast < people.size()){
            if(nums + people.get(fast) <= limit){
                if(nums+ people.get(fast) == limit){
                    count++;
                    nums = 0;
                    slow = fast;
                }
                else{
                    nums+=people.get(fast);
                    fast++;
                }
            }
            else{
                count++;
                nums = people.get(fast);
                slow=fast++;
            }
        }
        return count;
    }
    //Time Complexity : O(n log n) | Space Complexity: O(1)
    public int numRescueBoats2(int[] people, int limit){
        if(people == null){
            return 0;
        }
        if(people.length == 1 && people[0] > limit){
            return 0;
        }
        if(people.length == 1 && people[0] < limit){
            return 1;
        }
        Arrays.sort(people);

        int left = 0;
        int right  = people.length-1;
        int count = 0;

        while(left<right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
                count++;
            }
            else{
                right--;
                count++;
            }
        }

        return left == right? count+1:count;
    }
}
