package com.brianprojects.Leetcode.BinarySearch;

public class RemovableCharacters {
    //Time Complexity: O(s * log r) s being the size of the s string and r being the size of the removable array
    //Space Complexity: O(s) the size of the string since we need to create a character array
    public int maximumRemovals(String s, String p, int[] removable){
        if(s.length() ==0 || p.length() ==0){
            return 0;
        }
        char[] charArray = s.toCharArray();

        int l = 0;
        int r = removable.length-1;


        while(l<=r){
            int mid = (r+l)/2;

            for(var i = 0; i<=mid; i++){
                charArray[removable[i]] = '|';
            }

            if(isSubSequence(charArray, p)){
                l = mid+1;
            }
            else{
                for(var i = 0; i<=mid; i++){
                    if(charArray[removable[i]] == '|'){
                        charArray[removable[i]] = s.charAt(removable[i]);
                    }
                }
                r = mid -1;
            }
        }


        return r+1;
    }

    private boolean isSubSequence(char[] charArray, String p) {
        int pointer1 =0;
        int pointer2 =0;
        while(pointer1 < charArray.length && pointer2 < p.length()){
            if(charArray[pointer1] == p.charAt(pointer2)){
                pointer1++;
                pointer2++;
            }
            else{
                pointer1++;
            }
        }

        return pointer2 == p.length();
    }
}

//This question took me 3 wrong attempts before I realized that binary search works the best.
// What do I binary search then? I find the number of elements I can remove!
// The left boundary represents the lower limit (0 at first) while the right boundary represents the upper limit (the length of the removable array)
// Each time, I find the middle number (which is an attempt to remove that number of letters from the string)
// I also use an array of characters and replace those letters removed with the '/' symbol (can choose anything as long as it's a non-letter)
// This should be faster and more convenient to work with as compared to removing letters directly from a string (high time complexity from string concatenation)

//Firstly, I express the letters into an array of characters

//This is a standard procedure for checking if p is a subsequence of the array of characters.
//I use two-pointers to keep track of which char I'm looking at now in the char array, and another to keep track of which char I'm looking at in p.
// If the character wasn't 'removed' (remember this is indicated by the '/' symbol) and the characters are equal, I increment both pointers.
//Otherwise, I only increment the first pointer pointing to the array of characters.