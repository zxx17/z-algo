package com.zhuo.base;

import com.zhuo.entity.ListNode;
import org.junit.Test;

import java.util.*;


/**
 * @author Xinxuan Zhuo
 * @version 2023/11/28
 * <p>
 *
 * </p>
 */

public class TestOfDataStruct {


    @Test
    public void testHeap() {
        // 初始化小顶堆
        Queue<Integer> heap = new PriorityQueue<>();
        // 元素入堆
        heap.add(1);
        heap.add(4);
        heap.add(2);
        heap.add(6);
        heap.add(8);
        // 元素出堆（从小到大）
        heap.poll(); // -> 1
        heap.poll(); // -> 2
        heap.poll(); // -> 4
        heap.poll(); // -> 6
        heap.poll(); // -> 8
        System.out.println(heap.size());
    }




}
