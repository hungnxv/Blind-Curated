package com.github;

/**
 * Given a string s, return the longest palindromic substring in s.
 * ---------------------------------------------------------------------------------------------------------------------
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * ---------------------------------------------------------------------------------------------------------------------
 * Input: s = "cbbd"
 * Output: "bb"
 * ---------------------------------------------------------------------------------------------------------------------
 * Input: s = "a"
 * Output: "a"
 * ---------------------------------------------------------------------------------------------------------------------
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    /**
     * check every characters and expands 2 sides
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 0 || chars.length == 1)
            return s;
        int left = 0, right = 0;
        int maxLength = 0;
        String result =  String.valueOf(s.charAt(0));
        for (int i = 0; i < chars.length; i++) {
            left = i;
            right = i + 1;
            //even case
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                if (right - left + 1 > maxLength) {
                    result = s.substring(left, right + 1);
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }

            //odd case
            left = i - 1;
            right = i + 1;

            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                if (right - left + 1 > maxLength) {
                    result = s.substring(left, right + 1);
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }


        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("aaaa"));
    }
}
