package doit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < getCount(); i++) {
            list.add(getNumber());
            sort(list);
        }
        System.out.println("list = " + list);
    }

    private static int getCount() {
        return 5;
    }

    private static int getNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    //1 3 5 7, size = 4
    private static void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(list.size() - 1)) {
                list.add(i, list.get(list.size() - 1));
                list.remove(list.size() - 1);
                break;
            }
        }
    }
}
