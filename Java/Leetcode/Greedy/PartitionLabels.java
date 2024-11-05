package com.brianprojects.Leetcode.Greedy;

import java.util.*;

public class PartitionLabels {
    //Time Complexity: O(n) || Space Complexity: O(26) -> O(1)
    public List<Integer> partitionLabels(String s){
        if(s.length() ==0){return new ArrayList<>();}

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();


        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i),i);
        }
        int i =0;
        while(i<s.length()){
            int sum =1;
            int end = map.get(s.charAt(i));
            while(i<end){
                if(map.get(s.charAt(i)) > end){
                    end = map.get(s.charAt(i));
                }
                i++;
                sum++;
            }
            res.add(sum);
            i++;
        }
        return res;
    }
}
