package com.brianprojects.Leetcode.SlidingWindow;

import java.util.HashMap;

public class FruitsIntoBaskets {
    //Time Complexity: O(n) || Space Complexity:O(1)
    public int totalFruit(int[] fruits){
        if(fruits == null){return 0;}
        HashMap<Integer, Integer> map = new HashMap<>(2);
        map.put(fruits[0], 1);
        int sum = 1;
        int max = 1;
        int i = 0;
        int j = 1;
        while(j<fruits.length){
            if(!map.containsKey(fruits[j]) && map.size() <2){
                map.put(fruits[j], 1);
                sum++;
            }
            else if(map.containsKey(fruits[j]) && map.size() <=2){
                map.replace(fruits[j],map.get(fruits[j]), map.get(fruits[j])+1);
                sum++;
            }
            else{
                while(i<j && map.size() == 2){
                    if(map.get(fruits[i]) == 1){
                        map.remove(fruits[i]);
                    }
                    else{
                        map.replace(fruits[i],map.get(fruits[i]), map.get(fruits[i])-1);
                    }
                    sum--;
                    i++;
                }

                continue;
            }
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
    public int totalFruit2(int[] fruits){
        if(fruits == null){return 0;}

        int max = 1;
        int num1 = fruits[0];
        int num2 = -1;
        int val1 = 1;
        int val2 = 0;
        int i = 0;
        int j = 1;
        while(j<fruits.length){
            if(num1 == fruits[j]){
                val1++;
            }
            else if(num2<0){
                num2 = fruits[j];
                val2++;
            }
            else if(num2 == fruits[j]){
                val2++;
            }
            else{
                while(i<j && num2 !=-1){
                    if(num1 == fruits[i] && val1 == 1){
                        num1 = num2;
                        val1 = val2;
                        num2 = -1;
                        val2 = 0;
                    }
                    else if( num2 == fruits[i] && val2 == 1){
                        num2 = -1;
                        val2 = 0;
                    }
                    else{
                        val1-=num1==fruits[i]?1:0;
                        val2 -=num2==fruits[i]?1:0;
                    }
                    i++;
                }
                continue;
            }
            max = Math.max(max, val1+val2);
            j++;
        }
        return max;
    }
}
