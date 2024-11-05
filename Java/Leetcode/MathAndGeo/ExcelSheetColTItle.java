package com.brianprojects.Leetcode.MathAndGeo;

public class ExcelSheetColTItle {
    public String convertToTitle(int columnNumber){
        //Time Complexity: O(n) || Space Complexity: O(n)
        StringBuilder output = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            char c = (char) (columnNumber % 26 + 'A');
            columnNumber /= 26;
            output.append(c);
        }
        output.reverse();
        return output.toString();
    }
}
