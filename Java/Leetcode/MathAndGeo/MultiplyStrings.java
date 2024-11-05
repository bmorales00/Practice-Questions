package com.brianprojects.Leetcode.MathAndGeo;

public class MultiplyStrings {
    //Time Complexity: O(num1*num2) || Space Complexity: O(n)
    public String multiply(String num1, String num2){
        if(num1.length() == 0 || num2.length() == 0){return "";}

        StringBuilder res = new StringBuilder();
        if(num2.length() > num1.length()){
            var temp = num1;
            num1= num2;
            num2= temp;
        }
        int[] arr = new int[num1.length()*2];

        for(int i = 0; i<num1.length(); i++){
            for(int  j = 0; j<num2.length(); j++){
                int val1 = (num1.charAt(num1.length()-1-i) - '0');
                int val2 = (num2.charAt(num2.length()-1-j) - '0');
                int sum = (val1*val2)+arr[i+j];
                arr[i+j] = sum%10;
                arr[i+j+1] += sum/10;
            }
        }

        for(int  i = arr.length-1; i>=0; i--){
            if(res.isEmpty() && arr[i] == 0){
                continue;
            }
            res.append(arr[i]);
        }
        return res.isEmpty()?"0":res.toString();
    }
}

/*
long val1 = (long)Math.pow(10,num1.length()-1);
        long val2 = (long)Math.pow(10,num2.length()-1);
        long sum1 = 0;
        long sum2 = 0;

        for(char ch: num1.toCharArray()){
            sum1+=((ch-'0')*val1);
            val1/=10;
        }
        for(char ch: num2.toCharArray()){
            sum2+=((ch-'0')*val2);
            val2/=10;
        }

        res.append((double)sum1*sum2);
        return res.toString().replace('.',' ');
 */