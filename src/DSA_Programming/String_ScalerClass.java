package DSA_Programming;

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
}