package com.brianprojects.Leetcode.Graphs;

import java.util.*;

public class SafeStates {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public List<Integer> eventualSafeStates(int[][] graphs){
        if(graphs == null){return new ArrayList<>();}

        HashMap<Integer, Boolean> safeStates = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<graphs.length; i++){
            if(safeStates.containsKey(i) && safeStates.get(i)){
                res.add(i);
                continue;
            }
            if(dfs(graphs,safeStates,new HashSet<>(), i)){
                res.add(i);
            }
        }

        return res;
    }

    private boolean dfs(int[][] graphs, HashMap<Integer, Boolean> safeStates, HashSet<Integer> visited, int r) {
        if(graphs[r].length == 0){safeStates.put(r,true);return true;}
        if(visited.contains(r)){return false;}
        if(safeStates.containsKey(r)){return safeStates.get(r);}
        for(int i = 0; i<graphs[r].length; i++){
            visited.add(r);
            if(!dfs(graphs,safeStates,visited,graphs[r][i])){
                safeStates.put(r,false);
                return false;
            }
        }
        visited.remove(r);
        safeStates.put(r,true);
        return true;
    }


}
/*
private void dfs(int[][] graphs, boolean[] safe, HashSet<Integer> visited, int r) {
        if(visited.contains(r)){return;}

        if(graphs[r].length==0){safe[r] = true; return;}

        for(int c = 0; c<graphs[r].length; c++){
            if(graphs[r][c] < r){return;}
            if(!visited.contains(graphs[r][c]) || !visited.contains(r)){
                dfs(graphs,safe,visited,graphs[r][c]);
                visited.add(graphs[r][c]);
                safe[r] = safe[graphs[r][c]];
            }
        }
    }
 */