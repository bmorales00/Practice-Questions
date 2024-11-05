package com.brianprojects.LeetQues75.Tree.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//OPTIMIZE IT

public class CourseSchedule {
    /*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    You are given an array prerequisites where prerequisites[i] = [ai, bi]
    indicates that you must take course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.
     */

    public boolean canFinish(int numCourses, int[][] prerequisites){
        if(prerequisites == null){return false;}
        if(prerequisites.length ==0){return true;}
        int a = 0;
        int b = 1;

        HashMap<Integer, List<Integer>> visited = new HashMap<>();

        for(var i=0; i<prerequisites.length; i++){
            if(!canFinish(numCourses, prerequisites, visited, a,b, prerequisites[i][a]) || !visited.get(prerequisites[i][a]).isEmpty()){
                return false;
            }
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites, HashMap<Integer, List<Integer>> visited, int a, int b, int course){
        if(visited.containsKey(course) && !visited.get(course).isEmpty()){
            return false;
        }
        if(visited.containsKey(course) && visited.get(course).isEmpty()){
            return true;
        }
        visited.put(course, new ArrayList<>());
        for(var i =0; i<prerequisites.length; i++){
            if(prerequisites[i][a] == course){
                visited.get(course).add(prerequisites[i][b]);
                if(canFinish(numCourses, prerequisites, visited, a,b, prerequisites[i][b])){
                    visited.get(course).remove(a);
                }
            }
        }

        return true;
    }
}



//            visited.put(prerequisites[i][a], new ArrayList<>());
//            if(visited.containsKey(prerequisites[i][a])){
//                visited.get(prerequisites[i][a]).add(prerequisites[i][b]);
//            }
//            if(visited.containsKey(prerequisites[i][a])){
//                // 0, [] , 1 [],
//            }
//            canFinish(numCourses, prerequisites, visited, b,a, i);
//            visited.get(prerequisites[i][a]).add(prerequisites[i][b]);


/*
if(prerequisites == null){
            return false;
        }
        if(prerequisites.length ==0){
            return true;
        }
        HashMap<Integer, List<Integer>> visited = new HashMap<>();

        int a = 0;
        int b = 1;
        int num = 0;
        for(var i=0; i<prerequisites.length; i++){
            //int course = prerequisites[i][0];
            if(!canFinish(numCourses, prerequisites, visited, a,b,prerequisites[i][0])){
                return false;
            }
           //return (canFinish(numCourses, prerequisites, visited, a,b,prerequisites[i][0]));
        }

        return true;

        //If the hash does not work to keep track of visited, we use a set/array for it.
    }
    private boolean canFinish(int num,int[][] prerequisites, HashMap<Integer,
            List<Integer>> visited, int a, int b, int course){
        if(visited.containsKey(course)){
            return false;
        }
        visited.put(course, new ArrayList<>());
        for(var i = 0; i<prerequisites.length; i++){
            if(prerequisites[i][a] == course){
                visited.get(course).add(prerequisites[i][b]);
                return canFinish(i, prerequisites, visited, a,b, prerequisites[i][b]);
            }
        }
        return true;
 */