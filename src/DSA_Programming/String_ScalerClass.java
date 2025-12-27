package DSA_Programming;

public class String_ScalerClass {
    public static void main(String[] args) {
        String str = "aeiOUzaeiOUz";
        String operationop = operation(str);
        System.out.println(operationop);
        String str1 = "aaabaaa";
        String palindromeop = palindrome(str1);
        System.out.println(palindromeop);
        String toggleCaseop = toggleCase(str);
        System.out.println(toggleCaseop);
        String[] str3 = {"abcdefgh", "aefghijk", "abcefgh"};
        String longestCommonPrefixop = longestCommonPrefix(str3);
        System.out.println(longestCommonPrefixop);
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
    public static String palindrome(String s){
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
}