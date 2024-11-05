package com.brianprojects.Codality;

public class Prac {
//    public static int solution(int[] A){
//        if(A == null){
//            return 1;
//        }
//        int max = A[0];
//        int min = A[0];
//
//        HashSet<Integer> set = new HashSet<>();
//        for(var num: A){
//            max = Math.max(max, num);
//            min = Math.min(min, num);
//            set.add(num);
//        }
//        if(min <0 && max < 0){
//            return 1;
//        }
//        int small  = min+1;
//        while(small <=max){
//
//            if(!set.contains(small) && small >0){
//                return small;
//            }
//            small+=1;
//        }
//
//        return small;
//    }

//    public static int solution(int[] A){
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        int smallest = Integer.MAX_VALUE;
//        for(int i =0; i<A.length; i++){
//            if(!map.containsKey(A[i])){
//                map.put(A[i], new ArrayList<>());
//                map.get(A[i]).add(i);
//            }
//            else{
//                map.get(A[i]).add(i);
//            }
//        }
//        for(ArrayList<Integer> n : map.values()){
//            if(n.size() == 1){
//                smallest = Math.min(smallest, n.get(0));
//            }
//        }
//        return smallest == Integer.MAX_VALUE? -1:A[smallest];
//    }
    public static int solution(String S){
        char[] array = S.toCharArray();
        int start = 0;
        int end = array.length-1;

        while(start < end){
            if(array[start] != array[end]){
                return 0;
            }
            start++;
            end--;
        }
        return Character.isWhitespace(array[start])? -1: start;
    }
}
