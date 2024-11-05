package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingle {
    public List<List<Integer>> generate(int numRows){
        if(numRows<=0){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        if(numRows == 1){
            return res;
        }

        res.add(List.of(1,1));

        for(var  i = 2; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(var x = 0; x<=i; x++){
                if(x == 0 || x == i){
                    list.add(1);
                }
                else{
                    list.add(res.get(i-1).get(x-1) + res.get(i-1).get(x));
                }
            }
            res.add(list);
        }
        return res;

    }
}
