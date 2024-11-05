package com.brianprojects.HackerRank;

import java.util.List;

public class GridSearch {
    public String gridSearch(List<String> G, List<String> P){
        if(G == null || P == null || P.size() > G.size()){return "NO";}
        int r_g = G.size();
        int c_g = G.get(0).length();
        int r_p = P.size();
        int c_p = P.get(0).length();
        for(int r = 0; r<=r_g-r_p;r++){
            for(int c = 0; c<=c_g-c_p;c++){
                if(G.get(r).charAt(c) == P.get(0).charAt(0)){
                    if(isMatch(G,P,r,c)){
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }
    private static boolean isMatch(List<String> g, List<String> p, int r, int c) {
        for(int i = 0; i<p.size(); i++){
            for(int j=0; j<p.get(i).length(); j++){
                if(g.get(r+i).charAt(c+j) != p.get(i).charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
