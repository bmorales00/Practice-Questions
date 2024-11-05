package com.brianprojects.Leetcode.Greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas=0, totalCost = 0;
        int[] res = new int[gas.length];
        for(int i =0; i<gas.length;i++){
            res[i] = gas[i]-cost[i];
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas < totalCost){return -1;}
        int i =0;
        int j = i;
        int gasLeft = res[i];
        while(i<res.length && j<res.length-1){
            //if(j==i){return i;}
            if(res[i] <0 || gasLeft <0){
                gasLeft = res[(i+1)%res.length];
                i+=1;
                j=i;
                //j = (i+1)%res.length;
            }
            else{
                j+=1;
                gasLeft+=res[j];
            }
        }
        return gasLeft>=0?i:-1;
    }


}


/*
for(int i = 0; i<gas.length;i++){
            if(!(cost[i]>gas[i])){
                int left = gas[i]-cost[i];
                int j = (i+1)%gas.length;
                while(left>=0 && j!=i){
                    left+=gas[j];
                    left-=cost[j];
                    j=(j+1)%gas.length;
                }
                if(left >= 0){return i;}
            }
        }
 */