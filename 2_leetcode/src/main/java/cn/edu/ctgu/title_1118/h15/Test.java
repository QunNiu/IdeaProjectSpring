package cn.edu.ctgu.title_1118.h15;

import java.util.*;

/**
 * @author NiuQun
 * @date 2021/11/18
 */
public class Test {
    public static void main(String[] args) {

        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        hashSet.add(list1);
        hashSet.add(list2);
        System.out.println(hashSet);

    }

}

