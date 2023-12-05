package com.zhuo.base;

import org.junit.Test;

import static com.zhuo.mooc478.UseGcd.countOperations;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/5
 * <p>
 *
 * </p>
 */

public class TestOfUseGcd {

    @Test
    public void testCountOperations() {
        int x = 5, y = 3;
        int result = countOperations(3, 11);
        System.out.println("(1,1)到(" + x + "," + y + "), 需要: " + result);    }
}
