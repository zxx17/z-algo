package com.zhuo.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/6
 * <p>
 *
 * </p>
 */

public class TestOfArray {


    /**
     * 训练计划 I
     * 输入：actions = [1,2,3,4,5]
     * 输出：[1,3,5,2,4]  奇数在前偶数在后
     */
    public int[] trainingPlan(int[] actions) {
        int head = 0, last = actions.length - 1, temp;
        while (head < last) {
            while (head < last && (actions[head] & 1) == 1) {
                head++;
            }
            while (head < last && (actions[last] & 1) == 0) {
                last--;
            }
            temp = actions[head];
            actions[head] = actions[last];
            actions[last] = temp;
        }
        return actions;
    }


    /**
     * 文件组合
     * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。
     * 传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
     * <p>
     * 输入：target = 12
     * 输出：[[3, 4, 5]]
     * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
     */
    public int[][] fileCombination(int target) {
        //滑动窗口组成块
        int peer1 = 1, peer2 = 2, block = 3;
        List<int[]> res = new ArrayList<>();

        while (peer1 < peer2) {
            // 相等的情况，保存这个答案
            if (block == target) {
                int[] ans = new int[peer2 - peer1 + 1];
                for (int index = peer1; index <= peer2; index++) {
                    ans[index - peer1] = index;
                }
                res.add(ans);
            }
            //超了减一位左边的
            if (block >= target) {
                block -= peer1;
                peer1++;
            } else { //少了加一位右边的
                peer2++;
                block += peer2;
            }
        }
        return res.toArray(new int[0][]);
    }


    /**
     * 按规则计算统计结果 TODO
     * <p>
     * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
     * <p>
     * 输入：arrayA = [2, 4, 6, 8, 10]
     * 输出：[1920, 960, 640, 480, 384]
     */
    public static int[] calculate(int[] arrayA) {
        int n = arrayA.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arrayA[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arrayA[i + 1];
        }

        int[] arrayB = new int[n];
        for (int i = 0; i < n; i++) {
            arrayB[i] = left[i] * right[i];
        }

        return arrayB;
    }


}
