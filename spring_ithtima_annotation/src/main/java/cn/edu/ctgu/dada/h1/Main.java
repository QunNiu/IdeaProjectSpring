package cn.edu.ctgu.dada.h1;

import java.util.ArrayList;
        import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.nextLine();
        char[] charsM = m.toCharArray();
        String n = scanner.nextLine();
        char[] charsN = n.toCharArray();

        ArrayList<Character> listM = new ArrayList<>();
        ArrayList<Character> listN = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < charsM.length; i++) {
            if (charsM[i] == charsN[i]) {
                count++;
            } else {
                listM.add(charsM[i]);
                listN.add(charsN[i]);
            }
        }
        listM.retainAll(listN);
        String result = count + "Z" + listM.size() + "C";
        System.out.println(result);
    }

}
