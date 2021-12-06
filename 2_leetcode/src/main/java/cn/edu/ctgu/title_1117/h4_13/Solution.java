package cn.edu.ctgu.title_1117.h4_13;


import java.util.HashMap;

/**
 * @author NiuQun
 * @date 2021/11/7
 */
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('M', 1000);
        hashMap.put('D', 500);
        hashMap.put('C', 100);
        hashMap.put('L', 50);
        hashMap.put('X', 10);
        hashMap.put('V', 5);
        hashMap.put('I', 1);

        int result = 0;
        int i = 0;
        for (i= 0; i < s.length()-1; i++) {
            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i+1))) {
                result = result - hashMap.get(s.charAt(i));
            } else {
                result = result + hashMap.get(s.charAt(i));
            }
        }
        result = result + hashMap.get(s.charAt(i));
        return result;
    }
}
