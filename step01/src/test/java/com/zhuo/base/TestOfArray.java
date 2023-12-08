package com.zhuo.base;

import java.util.*;

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
     * 按规则计算统计结果 Done
     * <p>
     * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
     * <p>
     * 输入：arrayA = [2, 4, 6, 8, 10]
     * 输出：[1920, 960, 640, 480, 384]
     */
    public static int[] calculate(int[] arrayA) {
        int n = arrayA.length;
        int total = 1; // 计算总乘积
        int zeroCount = 0; // 统计值为0的生物群体数量个数
        for (int i = 0; i < n; i++) {
            if (arrayA[i] != 0) {
                total *= arrayA[i];
            } else {
                zeroCount++;
            }
        }
        int[] arrayB = new int[n];
        for (int i = 0; i < n; i++) {
            if (zeroCount == 0) {
                arrayB[i] = total / arrayA[i]; // 排除当前生物群体数量后的其他数量的乘积
            } else if (zeroCount == 1 && arrayA[i] == 0) {
                arrayB[i] = total; // 只有一个值为0的生物群体数量，排除该生物群体后，其他数量的乘积为total
            } else {
                arrayB[i] = 0; // 多于一个值为0的生物群体数量，其他数量的乘积为0
            }
        }
        return arrayB;
    }

    /**
     * 寻找文件副本
     * 设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
     * <p>
     * 输入：documents = [2, 5, 3, 0, 5, 0]
     * 输出：0 或 5
     */
    public int findRepeatDocument(int[] documents) {
        Arrays.sort(documents);
        for (int i = 0; i < documents.length - 1; i++) {
            if (documents[i] == documents[i + 1]) {
                return documents[i];
            }
        }
        return -1; // 如果没有找到重复数字，返回一个合适的值
    }

    public int findRepeatDocument2(int[] documents) {
        Set<Integer> container = new HashSet<>();
        for (int num : documents) {
            if (container.contains(num)) {
                return num;
            }
            container.add(num);
        }
        return -1;
    }


    /**
     * 螺旋遍历二维数组
     * 根据题目示例 array = [[1,2,3],[4,5,6],[7,8,9]] 的对应输出 [1,2,3,6,9,8,7,4,5]
     */
    public int[] spiralArray(int[][] array) {
        if (array == null) {
            return new int[0];
        }
        int left = 0, right = array[0].length - 1, top = 0, under = array.length - 1;
        int index = 0;
        int[] res = new int[array.length * array[0].length];

        while (true) {
            //left -> right
            for (int i = left; i <= right; i++) {
                res[index++] = array[top][i];
            }
            if (++top > under) {
                break;
            }
            //top -> under
            for (int i = top; i <= under; i++) {
                res[index++] = array[i][right];
            }
            if (left > --right) {
                break;
            }
            //right -> left
            for (int i = right; i >= left; i--) {
                res[index++] = array[under][i];
            }
            if (top > --under) {
                break;
            }
            //under -> top
            for (int i = under; i >= top; i--) {
                res[index++] = array[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }


}
