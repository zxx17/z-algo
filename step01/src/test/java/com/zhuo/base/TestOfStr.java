package com.zhuo.base;

import java.util.LinkedList;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/8
 * <p>
 *
 * </p>
 */

public class TestOfStr {


    /**
     * 路径加密
     * 假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
     * <p>
     * 示例 1：
     * 输入：path = "a.aef.qerf.bb"
     * 输出："a aef qerf bb
     */
    public String pathEncryption(String path) {
        return path.replace(".", " ");
    }

    public String pathEncryption2(String path) {
        StringBuilder sb = new StringBuilder();
        for (Character c : path.toCharArray()) {
            if (c == '.') {
                sb.append(' ');
            } else {
                sb.append(c);
            }
            ;
        }
        return sb.toString();
    }

    /**
     * 字符串中的单词反转
     * 输入: message = "the sky is blue"
     * 输出: "blue is sky the"
     */
    public  String reverseMessage(String message) {
        message = message.trim();
        message += " ";
        LinkedList<String> container = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : message.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    container.addFirst(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        sb.setLength(0);
        int size = container.size();
        for (int i = 0; i < size; i++) {
            sb.append(container.removeFirst());
            if (!container.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    /**
     * 双指针法
     */
    public  String reverseMessage2(String message) {
        message = message.trim();
        int flag = message.length()-1, index = flag;
        StringBuilder sb = new StringBuilder();

        while (index>=0){
            while (index >= 0 && message.charAt(index) != ' '){
                index--;
            }
            sb.append(message.substring(index+1, flag+1)).append(' ');
            while (index>=0&&message.charAt(index) == ' '){
                index--;
            }
            flag = index;
        }
        return sb.toString().trim();
    }

    /**
     * 某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
     *
     * 设定一个正整数目标值 target
     * 将 password 前 target 个字符按原顺序移动至字符串末尾
     *
     * 输入: password = "s3cur1tyC0d3", target = 4
     * 输出: "r1tyC0d3s3cu"
     * */
    public static String dynamicPassword1(String password, int target) {
        StringBuilder sb = new StringBuilder();

        String goLast = password.substring(0, target);
        String goFirst = password.substring(target);

       sb.append(goFirst).append(goLast);

        return sb.toString();
    }

    /**
     * 若面试规定不允许使用 切片函数 ，则使用此方法。
     */
    public static String dynamicPassword2(String password, int target) {
        StringBuilder sb = new StringBuilder();

        for (int i = target; i < password.length(); i++) {
            sb.append(password.charAt(i));
        }
        for (int i = 0; i < target; i++) {
            sb.append(password.charAt(i));
        }
        return sb.toString();
    }
    /**
     * 若面试规定只能用String
     **/
    public static String dynamicPassword3(String password, int target) {
       String res = "";
        for (int i = target; i < password.length(); i++) {
            res += password.charAt(i);
        }
        for (int i = 0; i < target; i++) {
            res += password.charAt(i);

        }
        return res;
    }

    /**
     * 不使用库函数的字符串转整数
     */
    public  static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int index = 0, sign = 1, total = 0;
        // 1. Remove Spaces
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        // 2. Handle signs
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 3. Convert number and avoid overflow
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            // Check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total ||
                    Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }



 }






