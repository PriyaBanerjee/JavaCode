package DSA_Programming;

import java.util.Arrays;
import java.util.HashSet;

public class String_ScalerClass {
    public static void main(String[] args) {
        String str = "aeiOUzaeiOUz";
        String operationop = operation(str);
        System.out.println(operationop);
        String str1 = "madam";
        String palindromeop = palindrome(str1);
        System.out.println(palindromeop);
        String toggleCaseop = toggleCase(str);
        System.out.println(toggleCaseop);
        String[] str3 = {"abcdefgh", "aefghijk", "abcefgh"};
        String longestCommonPrefixop = longestCommonPrefix(str3);
        System.out.println(longestCommonPrefixop);
        String s = "ABEBOBobCdfo";
        int amazingSubstringop = amazingSubstring(s);
        System.out.println(amazingSubstringop);
        char[] A = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0', '#'};
        int isalnumop = isalnum(A);
        System.out.println(isalnumop);
        int occurancescountop = occurancescount(s);
        System.out.println(occurancescountop);
        String reverseop = reverse(str);
        System.out.println(reverseop);

        // Test cases for reversing words in a string
        String str9 = "the sky is blue";
        String reversedStr1 = reverseWords(str9);
        System.out.println("Original: '" + str9 + "'");
        System.out.println("Reversed: '" + reversedStr1 + "'"); // Expected: 'blue is sky the'

        String str8 = "  this   is   ib  ";
        String reversedStr2 = reverseWords(str8);
        System.out.println("Original: '" + str8 + "'");
        System.out.println("Reversed: '" + reversedStr2 + "'");

        // Test cases for longest consecutive ones
        String binStr1 = "111011101";
        System.out.println("Longest for " + binStr1 + ": " + longestConsecutiveOnes(binStr1)); // Expected: 7

        String binStr2 = "111000";
        System.out.println("Longest for " + binStr2 + ": " + longestConsecutiveOnes(binStr2)); // Expected: 3
        int num2 = 236;
        System.out.println("Is " + num2 + " a Colorful Number? " + colorfulNumber(num2));

        String str7 = "abc";
        String str10 = "cbd";
        System.out.println("Are " + str7 + " and " + str10 + " anagrams? " + anagrams(str7, str10));

    }

    //Q3. Length of longest consecutive ones
    //Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
    // Q3. Length of longest consecutive ones - OPTIMIZED
    // Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
    // Find and return the length of the longest consecutive 1’s that can be achieved.
    public static int longestConsecutiveOnes(String A) { // important need to practice more and more
        int n = A.length();
        int totalOnes = 0;
        for (char c : A.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        // If all characters are '1', no swap is needed. The length is the total number of ones.
        if (totalOnes == n) {
            return totalOnes;
        }

        int maxLen = 0;
        int leftOnes = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                leftOnes++;
            } else { // We found a '0'
                // Look ahead to find consecutive ones on the right
                int rightOnes = 0;
                int j = i + 1;
                while (j < n && A.charAt(j) == '1') {
                    rightOnes++;
                    j++;
                }

                int currentSum = leftOnes + rightOnes;
                if (currentSum < totalOnes) {
                    // We can swap a '1' from elsewhere into the '0's place
                    maxLen = Math.max(maxLen, currentSum + 1);
                } else {
                    // No extra '1's to swap in, so we just group the existing ones
                    maxLen = Math.max(maxLen, currentSum);
                }

                // Reset leftOnes for the next segment
                leftOnes = 0;
            }
        }

        // Final check for a string that ends with '1's (e.g., "00111")
        // In this case, 'maxLen' might not have been updated for the last block of ones.
        return Math.max(maxLen, leftOnes);
    }


    // Methods
    //First concatenate the string with itself so string A becomes "aeiOUzaeiOUz".
    //Delete all the uppercase letters so string A becomes "aeizaeiz".
    //Now replace vowel with '#', A becomes "###z###z".
    //Q2. String operations
    public static String operation(String str){
        StringBuilder strB = new StringBuilder( str.length() * 2);
        String doubled = str + str;
        for (char c : doubled.toCharArray()){
            if(Character.isUpperCase(c)) continue;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                strB.append('#');
            }else{
                strB.append(c);
            }
        }
        return strB.toString();
    }
    //Q1. Longest Palindromic Substring - pending need to try again
    //We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
    public static String palindrome1(String s){
        int n = s.length();
        if(n ==0 ) return "";
        int start = 0, maxLen = 1;

        for (int center = 0; center < n; center++) {
            // Check odd length palindromes (center at i)
            int len1 = expand(s, center, center);
            // Check even length palindromes (center between i and i+1)
            int len2 = expand(s, center, center + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = center - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);

    }
    //best way
    public static String palindrome(String s){
        int n = s.length();
        int i =0 ;
        int j = n -1;
        int flag = 0 ;
        while(i < j && flag == 0){
            if(s.charAt(i) != s.charAt(j)){
                flag = 1;
            }
            i++;
            j--;
        }
        if(flag == 0){
            return "Palindrome";
        }else{
            return "Not Palindrome";
        }
    }

    private static int expand(String s, int left, int right){
        if(left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }

    //Q3. Toggle Case
    // tc : o(n) sc:o(n);
    public static String toggleCase(String A) {
//        char[] s = A.toCharArray();
//        int n = A.length();
//        for(int i =0;i <n;i++){
//            char ch = s[i];
//            if(ch >= 65 && ch <= 90){
//                s[i] = (char)(s[i] + 32);
//            }else{
//                s[i] = (char)(s[i] - 32);
//            }
//        }
//        return new String(s);
        StringBuilder sb = new StringBuilder();
        for(char c : A.toCharArray()) {
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
        return sb.toString();
    }

    //Q1. Longest Common Prefix
    //A = ["abcdefgh", "aefghijk", "abcefgh"];
    //o/p = a
    public static String longestCommonPrefix(String[] A) {
        if(A== null || A.length == 0) return "";
        StringBuilder sb = new StringBuilder(A[0]);
        int n = A.length;
        for(int i = 0 ; i < n ;i++){
            int len = Math.min(sb.length(), A[i].length());
            while(len > 0 && !A[i].startsWith(sb.substring(0,len))){
                len --;
            }
            sb.setLength(len);
            if(sb.isEmpty()) return "";
        }

        return sb.toString();
    }

    //You are given a string S, and you have to find all the amazing substrings of S.
    //An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
    //Q2. Amazing Subarrays
    public static int amazingSubstring(String s){
        int n = s.length();
        final int mod = 10003;
        int count = 0;
        for(int i =0;i<n;i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
                    s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
                count = (count + (n-i)) % mod;
            }
        }
        return count;
    }

    //You are given a function isalpha() consisting of a character array A.
    //Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.
    //Q3. Isalnum()
    public static int isalnum(char[] a){
        if(a.length == 0){
            return 0;
        }
        for(char ch : a){
            if(!Character.isLetterOrDigit(ch)){
                return 0;
            }
        }
        return 1;
    }

    //Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
    //Q4. Count Occurrences
    public static int occurancescount(String s){
        int count = 0;
        int n = s.length();
        if(n==0) return 0 ;
        for(int i =0 ; i <= n-3;i++){
            if(s.charAt(i) == 'b' && s.charAt(i+1) == 'o' && s.charAt(i+2) == 'b' || s.charAt(i) == 'B' && s.charAt(i+1) == 'O' && s.charAt(i+2) == 'B'){
                count++;
            }
        }
        return count;
    }

    //29/12/2025
    //Q4. Simple Reverse
    //Given a string A, you are asked to reverse the string and return the reversed string.
    public static String reverse(String s){
       // return new StringBuilder(s).reverse().toString();
        int n = s.length();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = n-1;
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end -- ;
        }
        return new String(chars);
    }

    //Q2. Reverse the String
    //You are given a string A of size N.
    //Return the string A after reversing the string word by word.
    //NOTE:A sequence of non-space characters constitutes a word.
    //Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
    //If there are multiple spaces between words, reduce them to a single space in the reversed string.

    public static String reverseWords(String A){
        String[] words = A.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for(int i = n-1; i >= 0; i--){
            sb.append(words[i]);
            if(i>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // Q2. Colorful Number
    // A number is COLORFUL if the product of every consecutive sequence of digits is unique.
    // Return 1 if it is, 0 otherwise.
    public static int colorfulNumber(int A) {
        // Convert the number to a string to easily access its digits.
        String numStr = Integer.toString(A);
        // Use a HashSet to keep track of the products we have already seen.
        HashSet<Long> productSet = new HashSet<>();
        int n = numStr.length();
        // Outer loop: Determines the starting digit of the subsequence.
        for (int i = 0; i < n; i++) {
            // This will hold the product of digits for the current subsequence.
            // Use 'long' to prevent overflow for larger products.
            long currentProduct = 1L;
            // Inner loop: Extends the subsequence from the start 'i' to the end of the number.
            for (int j = i; j < n; j++) {
                // Get the digit at position 'j' and multiply it with the current product.
                // (numStr.charAt(j) - '0') converts the character digit to an integer.
                currentProduct *= (numStr.charAt(j) - '0');

                // Try to add the product to our set.
                // If the product is already in the set, .add() will return 'false'.
                if (!productSet.add(currentProduct)) {
                    // We found a duplicate product, so the number is not colorful.
                    return 0;
                }
            }
        }
        // If we finish all the loops without finding any duplicates, the number is colorful.
        return 1;
    }

    //Q4. Check anagrams
    //You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
    //Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
    public static int anagrams(String A, String B){
        String str1 = A.replaceAll("\\s+", " ");
        String str2 = B.replaceAll("\\s+", " ");
        if(str1.length() != str2.length()){
            return 0;
        }else{
            char[] c1 = str1.toLowerCase().toCharArray();
            char[] c2 = str2.toLowerCase().toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            if(Arrays.equals(c1, c2)){
                return 1;
            }else{
                return 0;
            }
        }
    }

    //Count and say
    // veryimportant amazon, facebook


}



