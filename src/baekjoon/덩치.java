package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 백준 7568 덩치
 * https://www.acmicpc.net/problem/7568
 */
public class 덩치 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfPerson = scanner.nextInt();
        List<Person> people = new ArrayList<>();

        //필요한 값들을 입력받는다
        for (int i = 0; i < countOfPerson; i++) {
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            people.add(new Person(height, weight));
        }


        //랭크를 계산하여 출력한다.
        for (int i = 0; i < people.size(); i++) {
            int rank = 1;
            Person personWhoGetRank = people.get(i);
            for (Person person : people) {
                if (person.isBigger(personWhoGetRank)) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }

    }


    static class Person {
        private int height;
        private int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public boolean isBigger(Person other) {
            if ((this.weight > other.weight) && (this.height > other.height)) {
                return true;
            }

            return false;
        }
    }
}

