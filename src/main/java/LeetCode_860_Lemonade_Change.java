package src.main.java;

public class LeetCode_860_Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollersChangeLeft = 0;
        int tenDollersChangeLeft = 0;

        for (int i = 0; i < bills.length; i ++) {
            if (bills[i] == 5) {
                fiveDollersChangeLeft++;
            }

            if (bills[i] == 10) {
                fiveDollersChangeLeft -= bills[i]/5 - 1;
                tenDollersChangeLeft ++;
            }

            if (bills[i] == 20) {
                if (tenDollersChangeLeft > 0) {
                    tenDollersChangeLeft--;
                    fiveDollersChangeLeft--;
                } else {
                    fiveDollersChangeLeft -= 3;
                }
            }

            if (fiveDollersChangeLeft < 0 || tenDollersChangeLeft < 0) {
                return false;
            }
        }

        return true;
    }
}
