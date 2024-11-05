package com.brianprojects.Leetcode.Array;

import java.util.HashSet;

public class UniqueEmailAddresses {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int numUniqueAddresses(String[] emails){
        if(emails == null){return 0;}

        HashSet<String> set = new HashSet<>();

        for(String email:emails){
            String local = email.substring(0,email.indexOf("@"));
            String domain = email.substring(email.indexOf("@"));
            StringBuilder res = new StringBuilder();
            for(int i = 0; i<local.length(); i++){
                if(local.charAt(i) == '+'){break;}
                if(local.charAt(i) == '.'){continue;}
                res.append(local.charAt(i));
            }
            res.append(domain);
            set.add(res.toString());
        }
        return set.size();
    }
}
