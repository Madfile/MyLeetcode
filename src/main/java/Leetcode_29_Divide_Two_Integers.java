public class Leetcode_29_Divide_Two_Integers {
    class Solution {
//     public int divide(int dividend, int divisor) {
//         int originalDivisorAbs = Math.abs(divisor);

//         if (dividend == Integer.MAX_VALUE && divisor == 1) {
//             return Integer.MAX_VALUE;
//         }

//         if (dividend == Integer.MAX_VALUE && divisor == -1) {
//             return Integer.MIN_VALUE;
//         }

//         if (dividend == Integer.MIN_VALUE && divisor == 1) {
//             return Integer.MIN_VALUE;
//         }

//         if (dividend == Integer.MIN_VALUE && divisor == -1) {
//             return Integer.MAX_VALUE;
//         }

//         int flag = -1;
//         if ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0)) {
//             flag = 0;
//         }

//         dividend = Math.abs(dividend);
//         divisor = Math.abs(divisor);

//         int result = 0;
//         int cur = 0;
//         int n = 1;
//         while (cur + divisor <= dividend) {
//             cur += divisor;
//             result += n;
//             divisor += divisor;
//             n += n;
//         }

//         if (cur < dividend) {
//             int diff = dividend - cur;
//             while (diff > 0) {
//                 diff -= originalDivisorAbs;
//                 result++;
//             }

//             result--;
//         }

//         if (flag == -1) {
//             result = 0 - result;
//             //result = ~result + 1;
//         }

        //         return result;
//     }
        public int divide(int dividend, int divisor) {
            long ans = divide((long)dividend,(long)(divisor));
            long m = 2147483648L;
            if(ans == m ){
                return Integer.MAX_VALUE;
            }else{
                return (int)ans;
            }
        }
        public long divide(long dividend, long divisor) {
            long ans = 1;
            long sign = 1;
            if (dividend < 0) {
                sign = opposite(sign);
                dividend = opposite(dividend);
            }
            if (divisor < 0) {
                sign = opposite(sign);
                divisor = opposite(divisor);
            }
            long origin_dividend = dividend;
            long origin_divisor = divisor;

            if (dividend < divisor) {
                return 0;
            }

            dividend -= divisor;
            while (divisor <= dividend) {
                ans = ans + ans;
                divisor += divisor;
                dividend -= divisor;
            }
            long a = ans + divide(origin_dividend - divisor, origin_divisor);
            return sign > 0 ? a : opposite(a);
        }
        public long opposite(long x) {
            return ~x + 1;
        }
    }
}
