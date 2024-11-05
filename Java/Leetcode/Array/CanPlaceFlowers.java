package com.brianprojects.Leetcode.Array;

public class CanPlaceFlowers {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public boolean canPlaceFlowers(int[] flowerbed, int n){

        int i =0;
        int leftOver = n;
        while(i<flowerbed.length && leftOver !=0){
            if(flowerbed[i] ==0 && checked(flowerbed,i-1) && checked(flowerbed,i+1)){
                leftOver--;
                flowerbed[i] = 1;
            }
            i++;
        }
        return leftOver == 0;
    }

    private boolean checked(int[] flowerbed, int i) {
        if(i <0 || i>=flowerbed.length){return true;}
        return flowerbed[i] == 0;
    }
}
