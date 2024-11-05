package com.brianprojects.Codality;

public class MissingRolls {
        //To find the M:
        //M = (Elements of A + missing elements of A from F) / (A.length + F)
        //All we need are the missing elements so to find this we just rearrange this to:
        // Missing Elements =  M*(A.length) - Current Elements of A

    //The time complexity here is:
    public int[] missingRolls(int[] rolls , int n, int mean){
        int[] res = new int[n];
        int sumOfRolls = 0; //Current Elements
        int current = mean*(rolls.length+n); //
        for(var num: rolls){
            sumOfRolls+=num;
        }
        int missingElementsSum = current - sumOfRolls;

        //Our range here is from 1-6 for the elements, so n will be multiplied by 1  for the lowest and 6 for the highest
        if(missingElementsSum > n *6 || missingElementsSum < n){
            return new int[0];
        }
        for(var i = 0; i<res.length; i++){
            res[i] = missingElementsSum/(n-i);
            missingElementsSum -= res[i];
        }
        return res;
    }
}
