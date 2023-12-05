package com.zhuo.mooc478;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/5
 * <p>
 * homework
 * 1
 * 给定有序正整数对(a,b),每次操作可以把它们变为(a + b，b)或者(a，a + b)。
 * 给定互质的有序正整数对(x，y)，问从(1,1)开始，至少多少次操作可以得到给定的(x,y)?
 * 2
 * LC 1201
 * 3
 * LC 1250
 * </p>
 */

public class UseGcd {

    /**
     * eq LC914
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     * 示例 1：
     * 输入：deck = [1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * <p>
     * 示例 2：
     * 输入：deck = [1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     */
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            x = Math.abs(x);
            y = Math.abs(y);
            return gcd(y, x % y);
        }
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] nums = new int[10004];
        for (int x : deck) {
            ++nums[x];
        }
        int g = 0;
        for (int x : nums) {
            g = gcd(g, x);
            if (g == 1) {
                return false;
            }
        }
        return true;
    }


    /**
     * homework： 1
     */
    public static int countOperations(int x, int y) {
        int count = 0;
        while (x > 1 && y > 1) {
            if (x > y) {
                count += x / y;
                x = x % y;
            } else {
                count += y / x;
                y = y % x;
            }
        }
        if (x == 1 && y != 1) {
            count += (y - 1);
        } else if (y == 1 && x != 1) {
            count += (x - 1);
        }
        return count;
    }

    /**
     * homework: 2
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, n, a, b, c)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return r;
    }

    boolean check(int mid, int n, int a, int b, int c) {
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(lcm(a, b), c);
        long cnt = (long) mid / a + mid / b + mid / c - mid / ac - mid / bc - mid / ab + mid / abc;
        return cnt >= n;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }


}
