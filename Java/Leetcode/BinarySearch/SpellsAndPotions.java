package com.brianprojects.Leetcode.BinarySearch;

import java.util.Arrays;

public class SpellsAndPotions {
    //Time Complexity: O(s * log p) || Space Complexity: O(s)
    public int[] successfulPairs(int[] spells, int[] potions, long success){
        if(potions == null || spells == null){return null;}
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i<pairs.length; i++){
            int l = 0;
            int r = potions.length;
            int val = spells[i];
            while(l<r){
                int m = l+((r-l)/2);
                if((long) val * potions[m] >= success){
                    r = m;
                }
                else{l= m+1;}
            }
            pairs[i] = potions.length-l;
        }

        return pairs;
    }
}
