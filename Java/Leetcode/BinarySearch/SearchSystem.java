package com.brianprojects.Leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSystem {
    //                 Sorting     size of word  each character for every word in array
    //Time Complexity: O(n log n) + O(w)       + O(w*n)
    //Space Complexity: O(w)
    public List<List<String>> suggestedProducts(String[] products, String searchWord){
        if(products == null){return new ArrayList<>();}
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        int l = 0;
        int r = products.length-1;
        for(int i = 0; i<searchWord.length(); i++){
            ArrayList<String> words = new ArrayList<>();
            char ch = searchWord.charAt(i);
            while(l<=r && (products[l].length() == i || products[l].charAt(i) <ch)){l++;}
            while(l<=r && (products[r].length() == i || products[r].charAt(i) >ch)){r--;}
            for(int j =0; j<3 && l+j<=r; j++){
                words.add(products[l+j]);
            }
            res.add(words);
        }
        return res;
    }
}
