/**
 * 柠檬水找零
 * 1. 第一张一定是5元的
 * 2. 遇到10元的，找5元，判断5元的够不够，不够，就说明不能找零
 * 3. 遇到20元的，有10元，用一张，再加上5元；没有，用3张5元，不够，返回false
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (0 == bills.length) {
            return true;
        }
        if (5 != bills[0]) {
            return false;
        }
        final int m5 = 5;
        final int m10 = 10;
        final int m20 = 20;
        int c5 = 1, c10 = 0;
        for (int i = 1; i < bills.length; i++) {
            switch(bills[i]) {
                case m5:
                    c5++;
                    break;
                case m10:
                    c10++;
                    c5--;
                    break;
                case m20:
                    if (c10 > 0) {
                        c10--;
                        c5--;
                    } else {
                        c5 -= 3;
                    }
            }
            if (c5 < 0) {
                return false;
            }
        }
        return true;
    }
}