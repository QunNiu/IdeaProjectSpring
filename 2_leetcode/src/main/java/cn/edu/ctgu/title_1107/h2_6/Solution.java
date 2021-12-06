package cn.edu.ctgu.title_1107.h2_6;

import java.util.ArrayList;

/**
 * Z字形变换
 * @author NiuQun
 * @date 2021/11/7
 */
public class Solution {
    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        // 如果只有一行，则直接返回原字符串
        if (numRows == 1) {
            return s;
        }

        ArrayList<StringBuilder> rows = new ArrayList<>();
        // 如果numRows < s.length(),那么s中所有字母都排在z字形的对应位置，至少两列
        // 如果numRows >= s.length(), 那么s中所有字母都排在同一列，
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        // currentRow标记当前正处于哪一列
        int currentRow = 0;
        // flag为1表示列应当向下走，flag为-1表示列应当向上走
        int flag = -1;
        // 将s中的每个字符放置到合适的位置
        for (int i = 0; i < s.length(); i++) {
            rows.get(currentRow).append(s.charAt(i));
            if (currentRow == 0 || (currentRow == numRows-1)) {
                flag = -flag;
            }
            currentRow = currentRow + flag;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return  result.toString();
    }
}
