package com.brianprojects.Leetcode.MathAndGeo;

public class RobotBounded {
    //Time Complexity: O(n) || Space Complexity:O(1)
    public boolean isRobotBounded(String instructions){

        int[][] walk = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i<instructions.length(); i++){
            if(instructions.charAt(i) == 'G'){
                x+=walk[dir][0];
                y+=walk[dir][1];
            }
            else if(instructions.charAt(i) == 'L'){
                dir = (dir + 3) % 4;
            }
            else{
                dir = (dir + 1) % 4;
            }
        }

        return (x == 0 && y == 0)|| dir !=0;

    }
}
