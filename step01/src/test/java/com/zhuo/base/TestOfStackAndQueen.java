package com.zhuo.base;

import org.junit.Test;

import java.util.*;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/12
 * <p>
 *
 * </p>
 */

public class TestOfStackAndQueen {

    /**
     * 最小栈 AAAAAAAAAA
     * 请你设计一个 最小栈 。它提供 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * 实现 MinStack 类:
     * <p>
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     */
    //这个实现的getMin为O(n)
    static class MinStack1 {

        private LinkedList<Integer> container;

        /**
         * initialize your data structure here.
         */
        public MinStack1() {
            container = new LinkedList<>();
        }

        public void push(int x) {
            container.addLast(x);
        }

        public void pop() {
            if (container.size() == 0) {
                return;
            }
            container.removeLast();
        }

        public int top() {
            if (container.size() == 0) {
                return -1;
            }
            return container.getLast();
        }

        public int getMin() {
            if (container.size() == 0) {
                return -1;
            }
            Optional<Integer> min = container.stream()
                    .min(Integer::compareTo);
            return min.get();
        }
    }

    //利用一个哨兵值来监测最小值
    class MinStack2 {

        private LinkedList<Integer> container;
        private int sentry;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            container = new LinkedList<>();
            sentry = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x <= sentry) {
                container.addLast(sentry);
                sentry = x;
            }
            container.addLast(x);
        }

        public void pop() {
            if (container.isEmpty()) {
                return;
            }
            if (container.removeLast() == sentry) {
                sentry = container.removeLast(); // 更新最小值
            }
        }

        public int top() {
            if (container.isEmpty()) {
                return -1;
            }
            return container.getLast();
        }

        public int getMin() {
            return sentry;
        }
    }

//    @Test
//    public void testMinStack(){
//        MinStack1 minStack = new MinStack1();
//        minStack.push(-2);
//        minStack.push(2);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
//    }


    /**
     * 验证图书取出顺序AAAAAAAAAAAAAAA 3.25美团前端笔试
     * <p>
     * 输入：putIn = [6,7,8,9,10,11], takeOut = [9,11,10,8,7,6]
     * 输出：true
     * 解释：我们可以按以下操作放入并拿取书籍：
     * push(6), push(7), push(8), push(9), pop() -> 9,
     * push(10), push(11),pop() -> 11,pop() -> 10, pop() -> 8, pop() -> 7, pop() -> 6
     * <p>
     * 输入：putIn = [6,7,8,9,10,11], takeOut = [11,9,8,10,6,7]
     * 输出：false
     * 解释：6 不能在 7 之前取出。
     */
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        //模拟栈
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < putIn.length; i++) {
            stack.addLast(putIn[i]);
            while (!stack.isEmpty() && stack.getLast() == takeOut[index]) {
                stack.removeLast();
                index++;
            }

        }
        return stack.isEmpty();
    }

//    @Test
//    public void testValidateBookSequences() {
//        int[] putIn = {6, 7, 8, 9, 10, 11};
//        int[] takeOut1 = {9, 11, 10, 8, 7, 6};
//        int[] takeOut2 = {11, 9, 8, 10, 6, 7};
//        System.out.println(validateBookSequences(new int[]{1, 0, 4}, new int[]{1, 0, 4}));
//    }


}
