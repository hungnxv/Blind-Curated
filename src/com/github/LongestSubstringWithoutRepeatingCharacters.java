package com.github;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * ---------------------------------------------------------------------------------------------------------------------
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * ---------------------------------------------------------------------------------------------------------------------
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        Set<Character> characterSet;
        char[] chars = s.toCharArray();
        int longestSubString = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            characterSet = new HashSet<>();
            characterSet.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (characterSet.contains(chars[j])) {
                    break;
                } else
                    characterSet.add(chars[j]);
            }
            longestSubString = characterSet.size() > longestSubString ? characterSet.size() : longestSubString;
        }

        return longestSubString;
    }

    public static int lengthOfLongestSubstringOptimalWithSlidingWindow(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        Set<Character> window = new HashSet<>();
        int left = 0;
        int longestSubString = 0;
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            while (window.contains(chars[right])) {
                window.remove(chars[left]);
                left++;
            }
            window.add(chars[right]);
            longestSubString = Math.max(longestSubString, right - left + 1);//cai khuc nay la do keep track vu dai nhat
        }

        return longestSubString;
    }


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("au"));
//        System.out.println(lengthOfLongestSubstringOptimalWithSlidingWindow("abcabcbb"));
        System.out.println(lengthOfLongestSubstringOptimalWithSlidingWindow("pwwkew"));


    }
}
