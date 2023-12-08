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
    public static String reverseMessage(String message) {
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


}
