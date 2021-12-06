package cn.edu.ctgu.basic_kmp;

/**
 * @author NiuQun
 * @date 2021/11/5
 */
public class Kmp {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(kmpSearch(str1, str2, getKmpNext(str2)));

    }
    /**
     * 获取搜索词（即子串）的部分匹配值表
     * next[0]:代表A的部分匹配值为：0
     * next[1]:代表AB的部分匹配值：0
     * next[2]:代表ABC的部分匹配值：0
     * next[3]:代表ABCD的部分匹配值：0
     * next[4]:代表ABCDA的部分匹配值：1  左A 和 右A
     * ABCDA的前缀集合：{A, AB, ABC, ABCD}
     * ABCDA的后缀集合：{BCDA, CDA, DA, A}
     * 字符串ABCDA前缀和后缀的交集为{A}，所以部分字符串ABCDA的匹配值为1
     * next[5]:代表ABCDAB的部分匹配值：2 左AB 和 右AB
     * ...
     * next[6]:代表ABCDABD的部分匹配值:0
     * ABCDABD的前缀集合：{A, AB, ABC, ABCD, ABCDA, ABCDAB }
     * ABCDABD的后缀集合：{BCDABD, CDABC, DABC, ABD, BD, D}
     * 字符串ABCDABD前缀和后缀的交集为{}，所以部分字符串ABCDABD的匹配值为0
     */
    public static int[] getKmpNext(String childStr) {
        // 创建一个next数组，保存部分匹配值
        int[] next = new int[childStr.length()];
        // 如果字符串长度为1，那么它的部分匹配值为0,也就是说任何一个字符串的部分匹配值表的next[0]值均为0
        next[0] = 0;

        // 需要对整个字符串进行扫描
        for (int i = 1, j = 0; i < childStr.length(); i++) {
            // childStr.charAt(i) != childStr.charAt(j),我们需要从next[j-1]获取新的j
            // 同时知道我们发现有childStr.charAt(i) == childStr.charAt(j)成立时才退出
            // 比如ABCDABD [0, 0, 0, 0, 1, 2, 0]
            // 这是kmp算法的核心点
            while (j > 0 && childStr.charAt(i) != childStr.charAt(j)) {
                j = next[j-1];
            }

            // 当childStr.charAt(i) == childStr.charAt(j)时，部分匹配值需要逐渐+1,
            // 比如AAAB [0, 1, 2, 0]
            // 子串分别是A， AA， AAA，AAAB
            // A对应前缀集合{}，对应后缀集合{}, 部分匹配值为0
            // AA对应前缀集合{A}，对应后缀集合{A}, 部分匹配值为1
            // AAA对应前缀集合{A, AA}，对应后缀集合{AA, A}, 部分匹配值为2
            if (childStr.charAt(i) == childStr.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     *
     * @param parentStr 父串
     * @param childStr 子串
     * @param next 子串对应的部分匹配值表
     * @return 如果是-1，则表示没有匹配到；如果是非负整数，则表示第一次匹配到的位置
     */
    public static int kmpSearch(String parentStr, String childStr, int[] next) {
        for (int i = 0, j = 0; i < parentStr.length(); i++) {
            while (j > 0 && parentStr.charAt(i) != childStr.charAt(j)) {
                j = next[j-1];
            }
            if (parentStr.charAt(i) == childStr.charAt(j)) {
                j++;
            }
            if (j == childStr.length()) {
                // 说明已经找到了，则返回下标
                return i-j+1;
            }
        }
        return -1;
    }

}
