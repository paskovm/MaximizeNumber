import java.util.ArrayList;
import java.util.Collections;

public class Main {

//    maxPossible(9328, 456) ➞ 9658
//    maxPossible(523, 76) ➞ 763
//    maxPossible(9132, 5564) ➞ 9655
//    maxPossible(8732, 91255) ➞ 9755

    public static void main(String[] args) {
        System.out.println(maxPossible(9328, 456));
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));
    }

    public static int maxPossible(int n1, int n2) {
        ArrayList<Integer> arrayOfNumbersN1 = new ArrayList<>();
        ArrayList<Integer> arrayOfNumbersN2 = new ArrayList<>();

        arrayOfNumbersN1 = collectNumbers(n1);
        arrayOfNumbersN2 = collectNumbers(n2);

        int num;
        int index = -1;
        String result = "";

        for (int i = 0; i < arrayOfNumbersN1.size(); i++) {
            num = arrayOfNumbersN1.get(i);
            for (int j = 0; j < arrayOfNumbersN2.size(); j++) {
                if (num < arrayOfNumbersN2.get(j)) {
                    num = arrayOfNumbersN2.get(j);
                    index = j;
                }
            }
            if (index > -1) {
                arrayOfNumbersN2.set(index, 0);
            }

            result += num;
        }

        return Integer.parseInt(result);
    }

    private static ArrayList<Integer> collectNumbers(int n) {
        int num;
        ArrayList<Integer> arr = new ArrayList<>();

        while (true) {
            num = n % 10;
            n = n / 10;

            arr.add(num);
            if (n == 0) break;

        }
        Collections.reverse(arr);

        return arr;
    }

}
