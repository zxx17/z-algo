package com.zhuo.base;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;

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
     *
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     */
    //这个实现的getMin为O(n)
    static class MinStack1 {

        private LinkedList<Integer> container;

        /** initialize your data structure here. */
        public MinStack1() {
            container = new LinkedList<>();
        }

        public void push(int x) {
            container.addLast(x);
        }

        public void pop() {
            if(container.size()==0){
                return;
            }
            container.removeLast();
        }

        public int top() {
            if(container.size()==0){
                return -1;
            }
            return container.getLast();
        }

        public int getMin() {
            if(container.size()==0){
                return -1;
            }
            Optional<Integer> min = container.stream()
                    .min(Comparator.naturalOrder());
            return min.get();
        }
    }

    //利用一个哨兵值来监测最小值
     class MinStack2 {

        private LinkedList<Integer> container;
        private int sentry;

        /** initialize your data structure here. */
        public MinStack2() {
            container = new LinkedList<>();
            sentry = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(x <= sentry){
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

    @Test
    public void testMinStack(){
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(2);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());


    }


}
