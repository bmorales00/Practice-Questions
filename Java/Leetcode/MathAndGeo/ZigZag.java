package com.brianprojects.Leetcode.MathAndGeo;

public class ZigZag {
    //Time Complexity: O(m*n) || Space Complexity: O(n*m)
    public String convert(String s, int numRows){
        if(s == null){return "";}
        if(s.length() == 1 || numRows==1){return s;}
        StringBuilder res =new StringBuilder();
        int col = (s.length()/2)+1;
        char[][] arr = new char[numRows][col];
        arr[0][0] = s.charAt(0);
        int i = 1;
        int c = 0;
        while(i<s.length()){
            for(int r = 1; r<numRows; r++){
                if(i>=s.length()){break;}
                arr[r][c] = s.charAt(i++);
            }
            for(int r = numRows-2; r>=0;r--){
                if(i>=s.length()){break;}
                arr[r][++c] = s.charAt(i++);
            }
        }
        for(char[] row:arr){
            for(char ch:row){
                if(ch !=0){
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
    //Time Complexity: O(m*numRows) || Space Complexity:O(n*m)
    public String convert2(String s, int numRows){
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int direction = 1;
        int currentRow = 0;
        for (char ch : s.toCharArray()) {
            rows[currentRow].append(ch);
            if (currentRow == 0) {
                direction = 1;
            } else if (currentRow == numRows - 1) {
                direction = -1;
            }
            currentRow += direction;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}
