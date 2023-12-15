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


    /**
     * 科技馆内有一台虚拟观景望远镜，它可以用来观测特定纬度地区的地形情况。
     * 该纬度的海拔数据记于数组 heights ，其中 heights[i] 表示对应位置的海拔高度。请找出并返回望远镜视野范围 limit 内，可以观测到的最高海拔值。
     *
     * 输入：heights = [14,2,27,-5,28,13,39], limit = 3
     * 输出：[27,27,28,28,39]
     */
    //超时
    public  int[] maxAltitude(int[] heights, int limit) {
        if(heights.length ==0 || limit == 0){
            return new int[0];
        }

        LinkedList<Integer> container = new LinkedList<>();
        for (int height : heights) {
            container.addLast(height);
        }

        int nowMax=Integer.MIN_VALUE;
        List<Integer> maxResult = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        while (container.size() >= limit){
            for (int i = 0; i < limit; i++) {
                Integer first = container.get(i);
                if(nowMax < first){
                    nowMax = first;
                    if(!maxResult.isEmpty()){
                        maxResult.clear();
                    }
                    maxResult.add(nowMax);
                }
            }
            result.add(maxResult.get(0));
            nowMax=Integer.MIN_VALUE;
            container.removeFirst();
        }
        return result.stream().filter(integer -> integer!=null).mapToInt(i->i).toArray();
    }
    //最大堆
    public int[] maxAltitute2(int[] heights, int limit){
        if (heights.length == 0 || limit == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            maxHeap.offer(heights[i]);
            if (maxHeap.size() > limit) {
                maxHeap.remove(heights[i - limit]);
            }
            if (i >= limit - 1) {
                result.add(maxHeap.peek());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
    //单调队列
    public int[] maxAltitute3(int[] heights, int limit){
        if(heights.length == 0 || limit == 0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[heights.length - limit + 1];
        for(int j = 0, i = 1 - limit; j < heights.length; i++, j++) {
            // 删除 deque 中对应的 heights[i-1]
            if(i > 0 && deque.peekFirst() == heights[i - 1]){
                deque.removeFirst();
            }
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < heights[j]){
                deque.removeLast();
            }
            deque.addLast(heights[j]);
            // 记录窗口最大值
            if(i >= 0){
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

//    @Test
//    public void testMaxAltitude(){
//        System.out.println(Arrays.toString(maxAltitute3(new int[]{14, 2, 27, -5, 28, 13, 39}, 3)));
//    }

    /**
     * AAAAAAAAAAA
     * 请设计一个自助结账系统，该系统需要通过一个队列来模拟顾客通过购物车的结算过程，需要实现的功能有：
     * get_max()：获取结算商品中的最高价格，如果队列为空，则返回 -1
     * add(value)：将价格为 value 的商品加入待结算商品队列的尾部
     * remove()：移除第一个待结算的商品价格，如果队列为空，则返回 -1
     * 注意，为保证该系统运转高效性，以上函数的均摊时间复杂度均为 O(1)
     *
     * 示例 1：
     * 输入:
     * ["Checkout","add","add","get_max","remove","get_max"]
     * [[],[4],[7],[],[],[]]
     * 输出: [null,null,null,7,4,7]
     */
    class Checkout {
        Queue<Integer> queue;
        Deque<Integer> deque;
        public Checkout() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }
        public int get_max() {
           return deque.isEmpty() ? -1 : deque.getFirst();
        }
        public void add(int value) {
           queue.add(value);
           while (!deque.isEmpty() && deque.getLast() < value){
                deque.removeLast();
           }
           deque.addLast(value);
        }
        public int remove() {
            if(queue.isEmpty()) return -1;
            if(queue.peek().equals(deque.peekFirst()))
                deque.pollFirst();
            return queue.poll();
        }
    }



}
