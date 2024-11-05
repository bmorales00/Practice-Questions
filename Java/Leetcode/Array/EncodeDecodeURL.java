package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class EncodeDecodeURL {
    HashMap<String, Integer> encodeMap;
    HashMap<Integer,String> decodeMap;
    int tinyUrl;
    public EncodeDecodeURL(){
        this.encodeMap = new HashMap<>();
        this.decodeMap =new HashMap<>();
        this.tinyUrl = 0;
    }
    public String encode(String longUrl){

        String strTinyUrl = Integer.toString(tinyUrl);
        decodeMap.put(tinyUrl,longUrl);
        encodeMap.put(longUrl, tinyUrl);
        tinyUrl++;
        return strTinyUrl;
    }
    public String decode(String shortUrl){
        return decodeMap.get(Integer.parseInt(shortUrl));
    }

}
