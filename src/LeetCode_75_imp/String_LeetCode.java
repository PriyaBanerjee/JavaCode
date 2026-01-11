package LeetCode_75_imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class String_LeetCode {
    public static void main(String[] args) {
        String s = "anagtam", t = "babad";
        System.out.println(isAnagram(s, t));
        String[] s1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s1));
        System.out.println(lengthOfLongestSubstring(t));
        String spal = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(spal));
        String rep = "AABABBA";
        System.out.println(characterReplacement(rep,1));
        String min = "ADOBECODEBANC", tar = "ABC";
        System.out.println(minWindow(min,tar));
        String param = "()[]{}{)";
        System.out.println(isValid(param));
        System.out.println(longestPalindrome(t));

    }

    //Methods
    public static boolean isAnagram(String s, String t) {
        int n = s.length();
        int n1 = t.length();
        if (n != n1) return false;
        if (s.charAt(0) == 0 || t.charAt(0) == 0) return false;
        char[] ch = s.toCharArray();
        char[] ch1 = t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch1);
        if (Arrays.equals(ch, ch1)) {
            return true;
        }
        return false;
    }


//    public static List<List<String>> groupAnagrams(String[] strs){ // tc(O(N * K log K))
//        Map<String, List<String>> map = new HashMap<>();
//        for (String str : strs){
//            char[] ch = str.toCharArray();
//            Arrays.sort(ch);
//            String key = new String(ch);
//            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
//        }
//        return new ArrayList<>(map.values());
//    }

    public static List<List<String>> groupAnagrams(String[] strs) { // tc : O(N * K)
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i : count) {
                key.append(i).append(',');
            }
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    //3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            // Shrink window while duplicate exists
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add current character
            set.add(s.charAt(right));

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    //125. Valid Palindrome
    public static boolean isPalindrome(String s){
        String clean = s.replaceAll("[^a-zA-Z0-9^]","").toLowerCase();
        int n = clean.length();
        Set<String> set = new HashSet<>();
        int left = 0 , right = n-1;
        while(left < right){
            if(clean.charAt(left) != clean.charAt(right)){
                return false;
            }
            left++;
            right --;
        }

        return true;
    }

    //424. Longest Repeating Character Replacement
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxfreq = 0;
        int maxwindow = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);
            int windowlength = right - left + 1;
            if (windowlength - maxfreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            windowlength = right - left + 1;
            maxwindow = Math.max(maxwindow, windowlength);
        }
        return maxwindow;

    }

    //76. Minimum Window Substring
    public static String minWindow(String s, String t) {
        int[] arr = new int[128];
        char[] ch_s = s.toCharArray();
        char[] ch_t = t.toCharArray();
        for(char cur : ch_t){
            arr[cur]++;
        }
        int left = 0,right = 0;
        int counter = 0;
        int minlen = Integer.MAX_VALUE;
        String ans = "";
        while(right < ch_s.length){
            //expand window
            char curChar = ch_s[right];
            if(--arr[curChar] >= 0){
                counter ++;
            }
            //shrink window
            while(counter == ch_t.length){
                int curWindow = right - left + 1;
                if(curWindow < minlen){
                    minlen = curWindow;
                    ans = s.substring(left , right+1);
                }
                char leftChar = ch_s[left];
                if(++arr[leftChar] >0){
                    counter--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }

    //20. Valid Parentheses
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.add(')');
            }else if(ch == '{'){
                stack.add('}');
            }else if(ch == '['){
                stack.add(']');
            }else if(stack.isEmpty() || stack.pop() != ch){
                return false;
            }

        }
        return true;
    }

    //5. Longest Palindromic Substring
    public static String longestPalindrome(String s){
        if(s.length() <= 1){
            return s;
        }
        String LPS = "";
        for(int i = 1; i < s.length();i++){
            //consider odd length
            int low = i;
            int high = i;
            while(s.charAt(low) == s.charAt(high)){
                low --;
                high++;
                if(low == -1 || high == s.length()) {
                    break;
                }
                String palindrome = s.substring(low+1,high);
                if(palindrome.length() > LPS.length()){
                    LPS = palindrome;
                }
            }
            //consider even length
             low = i-1;
             high = i;
             while (s.charAt(low) == s.charAt(high)){
                 low--;
                 high++;
                 if(low == -1 || high == s.length()){
                     break;
                 }
                 String palindrome = s.substring(low+1, high);
                 if(palindrome.length() > LPS.length()){
                     LPS= palindrome;
                 }
             }
        }
        return LPS;
    }
}
