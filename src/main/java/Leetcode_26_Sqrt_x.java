package src.main.java;

public class Leetcode_26_Sqrt_x {
    public int mySqrt(int x) {
        int L = 1, R = x;
        int ans = 0;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            int div = x / mid;
            if (div == mid) {
                return mid;
            } else if (mid < div) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }
}
