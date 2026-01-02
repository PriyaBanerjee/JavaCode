package Self_Practice_Leetcode;

import java.util.Arrays;

public class Practice_string {
    public static void main(String[] args){
        String test1 = "babad";
        System.out.println("Input: " + test1);
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring(test1)); // Expected: "bab" or "aba"
        String test2 = "cbbd";
        System.out.println("Input: " + test2);
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring(test2));
        String test3 = "madam";
        System.out.println("Input: " + test3);
        System.out.println(" Palindromic : " + Palindrome(test3));
        String test4 = "the sky is blue";
        System.out.println("Input: " + test4);
        System.out.println("Reversed: " + reversewords(test4));
        String str = "aeiOUzaeiOUz";
        System.out.println(toggleCase(str));
        String[] str3 = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(longestCommonPrefix(str3));
        String str4 = "abcdeiihdbnjidh";
        System.out.println(amazingSubstrings(str4));

    }

    //Longest Palindromic Substring
    public static String longestPalindromicSubstring(String A){
        int n = A.length();
        if (n <= 1) return A;

        String LPS = A.substring(0, 1);
        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++) {
            // Odd length
            int low = i, high = i;
            while (low >= 0 && high < n && A.charAt(low) == A.charAt(high)) {
                low--;
                high++;
                if(low <= -1 && high > n)
                    break;
            }
            int len1 = high - low - 1;
            if (len1 > maxLen) {
                maxLen = len1;
                start = low + 1;
            }

            // Even length
            low = i;
            high = i + 1;
            while (low >= 0 && high < n && A.charAt(low) == A.charAt(high)) {
                low--;
                high++;
                if(low <= -1 && high > n)
                    break;
            }
            int len2 = high - low - 1;
            if (len2 > maxLen) {
                maxLen = len2;
                start = low + 1;
            }
        }
        LPS = A.substring(start, start + maxLen);
        return LPS;
    }

    //Palindrome chcek
    public static int Palindrome(String str){
        int n = str.length();
        int start = 0 ;
        int end = n-1;
        int flag = 0;
        while (start< end && flag == 0){
            if(str.charAt(start) != str.charAt(end)){
                flag = 1;
            }
            start ++;
            end -- ;

        }
        return flag;
    }

    //Reverse Words in String
    public static String reversewords(String str){
        String[] words = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        if(n == 0) return str;
        for(int i = n-1; i >=0;i--){
            sb.append(words[i]);
            if(i>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //Toggle String Case
    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()){
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
        return sb.toString();
    }

    //Longest Common Prefix
    public static String longestCommonPrefix(String[] A) {
        int n = A.length;
        if( A == null || n < 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(A);
        char[] First = A[0].toCharArray();
        char[] last = A[A.length-1].toCharArray();
        for(int i = 0 ; i < First.length ; i++){
            if(First[i] != last[i])
                break;
            sb.append(First[i]);
        }
        return sb.toString();
    }

    //String Immutability Demos

    //• Amazing Subarrays: Count vowel-starting substrings mod 10003.
    //Practice these for contests; all use Java Solution class format per your history.
    public static int amazingSubstrings(String A) {
        int n = A.length();
        int count = 0;
        final int mod = 10003;
        for(int i = 0 ; i < n;i++){
            if(A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o' || A.charAt(i) == 'u' ||
                    A.charAt(i) == 'A' || A.charAt(i) == 'E' || A.charAt(i) == 'I' || A.charAt(i) == 'O' || A.charAt(i) == 'U'){
                count = (count + (n-i)) % mod;
            }
        }
        return count;
    }

}
