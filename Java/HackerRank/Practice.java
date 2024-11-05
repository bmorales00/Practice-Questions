package com.brianprojects.HackerRank;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static List<String> processLogs(List<String> logs, int threshold) {
        if(logs == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i< logs.size(); i++){
            String[] strList = logs.get(i).split(" ");
            for(int j = 0; j<2;j++){
                if(j>0 && strList[j].equals(strList[j-1])){continue;}
                if(!map.containsKey(strList[j])){
                    map.put(strList[j], 0);
                }
                map.replace(strList[j], map.get(strList[j]), map.get(strList[j])+1);
            }
        }

        for(String item: map.keySet()){
            if(map.get(item) >=threshold){
                list.add(Integer.parseInt(item));
            }
        }
        Collections.sort(list);

        return list.stream().map(s -> Integer.toString(s)).collect(Collectors.toList());
    }

    public static int countGroups(List<String> related){
        if(related == null){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for(var i =0; i< related.size(); i++){
            for(var j = 0; j< related.get(0).length(); j++){
                if(i == j){continue;}
                if(related.get(i).charAt(j) == '1' && !(map.containsKey(j) && map.get(j) == i)){
                    map.put(i,j);
                }
            }
        }
        return map.size();

    }
}
