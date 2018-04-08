package solution5;

/**
 * 最长回文字串
 *
 * @author LinChangyi
 * @date 2018/4/4
 **/
public class Solution {
    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int max = 1, ti = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                if (s.charAt(j) == s.charAt(j + i) && (i <= 1 || pal[j + 1][j + i - 1])) {
                    pal[j][j + i] = true;
                    if (i + 1 > max) {
                        max = i + 1;
                        ti = j;
                    }
                }
            }
        }
        return s.substring(ti, ti + max);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
