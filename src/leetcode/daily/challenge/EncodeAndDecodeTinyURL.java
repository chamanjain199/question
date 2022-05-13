package leetcode.daily.challenge;

import java.util.HashMap;

class Codec {

    static int index = 0;
    static HashMap<String, String> maps = new HashMap<>();
    static final String shortUlr = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        index++;
        maps.put(shortUlr + index, longUrl);
        return shortUlr + index;


    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
       return  maps.get(shortUrl);
    }
    public String encode1(String longUrl) {
        return  longUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode1(String shortUrl) {
        return shortUrl;
    }
}

public class EncodeAndDecodeTinyURL {
}
