package solution4;

/**
 * @author LinChangyi
 * @date 2018/3/29
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 **/
public class Solution {

    private double findKth(int[] A, int startOfA, int[] B, int startOfB, int k) {
        if (startOfA >= A.length) {
            return B[startOfB + k - 1];
        }
        if (startOfB >= B.length) {
            return A[startOfA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }
        int halfKthOfA = startOfA + k / 2 - 1 < A.length ? A[startOfA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfB = startOfB + k / 2 - 1 < B.length ? B[startOfB + k / 2 - 1] : Integer.MAX_VALUE;
        if (halfKthOfA < halfKthOfB) {
            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
        } else {
            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        if ((A.length + B.length) % 2 == 0) {
            return (findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1)
                    + findKth(A, 0, B, 0, (A.length + B.length) / 2))
                    / 2.0;
        }
        return findKth(A, 0, B, 0, (A.length + B.length) / 2 + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }
}
