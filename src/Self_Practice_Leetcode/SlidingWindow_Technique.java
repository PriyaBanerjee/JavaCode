package Self_Practice_Leetcode;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow_Technique {
    public static void main(String[] args){
        String s = "abcabcbb";
        LongestSubstring(s);
        String s1 = "ADOBECODEBANC";
        String t = "ABC";
    }

    //Method
    //3. Longest Substring Without Repeating Characters
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
    public static void LongestSubstring(String s){
        int n = s.length();
        int maxlen = 0;
        Map<Character,Integer> pos = new HashMap<>();
        int left = 0;
        for(int r = 0 ; r<n;r++){
            char c = s.charAt(r);
            if(pos.containsKey(c)){
                left = Math.max(left,pos.get(c)+1);
            }
            pos.put(c,r);
            maxlen = Math.max(maxlen, r - left +1);
        }
        System.out.println("Longest Substring Without Repeating Characters: "+maxlen);
    }

    //76. Minimum Window Substring
    //Output: "BANC"
    //Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
    //Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
    public static void MinimumWindowSubstring(String s, String t){
        int n = s.length();
        int m = t.length();
    }

}
