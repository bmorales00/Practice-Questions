package com.brianprojects.Leetcode.Graphs;
import java.util.*;

//Time Complexity is O(V+E) | Space Complexity is O(V) or O(n) num of courses
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses <=0){
            return new int[0];
        }
        int[] res = new int[numCourses];

        List<Integer> list= new ArrayList<>();
        HashSet<Integer> visiting = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        for(var i = 0; i<numCourses; i++) {
            if (hasCycle(prerequisites, i, visited, visiting, list)) {
                return new int[0];
            }
        }

        for(var i = 0; i<res.length; i++ ){
            res[i] = list.remove(list.size()-1);
        }

        return res;
    }

    private boolean hasCycle(int[][] prerequisites,int v, HashSet<Integer> visited, HashSet<Integer> visiting, List<Integer> list) {

        if(visiting.contains(v)){
            return true;
        }
        if(visited.contains(v)){
            return false;
        }
        visiting.add(v);
        visited.add(v);

        for(var i = 0; i< prerequisites.length; i++){
            if(prerequisites[i][1] == v && hasCycle(prerequisites,prerequisites[i][0],visited,visiting,list)){
                return true;
            }
        }
        visiting.remove(v);
        list.add(v);
        return false;
    }


}
