package solution3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author LinChangyi
 * @date 2018/3/28
 **/
class Solution {
    /**
     * 递归实现，超时，复杂度n3
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_recursion(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int i = 1;
        for (; i < s.length(); ++i) {
            if (s.substring(0, i).indexOf(s.charAt(i)) >= 0) {
                break;
            }
        }
        int max = lengthOfLongestSubstring_recursion(s.substring(1));
        return i > max ? i : max;

    }


    /**
     * 动态规划，超时
     * 时间复杂度 n3
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_dp(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[][] mx = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            mx[i][i] = 1;
        }
        for (int k = 1; k < s.length(); ++k) {
            for (int i = 0; i < s.length() - k; ++i) {
                int leftLongest = leftLongestSubstring(s.substring(i));
                int rightLongest = rightLongestSubstring(s.substring(0, i + k + 1));

                int max = leftLongest;
                if (rightLongest > max) {
                    max = rightLongest;
                }
                if (mx[i][i + k - 1] > max) {
                    max = mx[i][i + k - 1];
                }
                if (mx[i + 1][i + k] > max) {
                    max = mx[i + 1][i + k];
                }
                mx[i][i + k] = max;
            }
        }
        return mx[0][s.length() - 1];
    }

    private int rightLongestSubstring(String chars) {
        if (chars.length() <= 1) {
            return chars.length();
        }
        Set<Character> sets = new HashSet<Character>();
        sets.add(chars.charAt(chars.length() - 1));
        int i = 1;
        for (; i < chars.length(); ++i) {
            if (sets.contains(chars.charAt(chars.length() - 1 - i))) {
                break;
            }
            sets.add(chars.charAt(chars.length() - 1 - i));
        }
        return i;
    }

    private int leftLongestSubstring(String chars) {
        if (chars.length() <= 1) {
            return chars.length();
        }
        Set<Character> sets = new HashSet<Character>();
        sets.add(chars.charAt(0));
        int i = 1;
        for (; i < chars.length(); ++i) {
            if (sets.contains(chars.charAt(i))) {
                break;
            }
            sets.add(chars.charAt(i));
        }
        return i;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0, ans = 0, length = 0;
        Map<Character, Integer> charIndex = new HashMap<Character, Integer>();
        while (i < n && j < n) {
            char ch = s.charAt(j);
            if (charIndex.containsKey(ch) && charIndex.get(ch) >= i) {
                ans = length > ans ? length : ans;
                length = length - (charIndex.get(ch) - i);
                i = charIndex.get(ch) + 1;
            } else {
                length++;
            }
            charIndex.put(ch, j++);
        }
        return ans > length ? ans : length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("aab"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("ohomm"));
    }
}
