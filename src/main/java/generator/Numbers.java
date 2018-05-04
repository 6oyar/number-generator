package generator;

import java.util.TreeSet;

/**
 * Заготовка под хранение уже выданных номеров,
 * не рабочая, надо доделывать
 *
 *
 * */

public class Numbers {
    private static TreeSet<String> set = new TreeSet<String>();

    public static TreeSet getIssuedNumbers() {
        return set;
    }

    public static void putNumber(String number) {
        set.add(number);
    }
}
