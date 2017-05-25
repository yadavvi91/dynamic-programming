package org.yadavvi.combinationofnumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 24/5/17.
 */
public class CombinationOfNumbers {

    public static void main(String[] args) {
        combination(18, 3);
    }

    private static void combination(int value, int counts) {
        List<List<Integer>>[] arr = new List[value + 1];
        arr[0] = new ArrayList<>();
        arr[0].add(new ArrayList<>());
        combination(value, counts, arr);
        for (List<Integer> list : arr[value]) {
            System.out.println(list);
        }
    }

    private static void combination(int value, int counts, List<List<Integer>>[] arr) {
        for (int i = 1; i <= value; i++) {
            arr[i] = new ArrayList<>();
            for (int count = 0; count <= value; count++) {
                if (i - count < 0) break;

                for (List<Integer> list : arr[i - count]) {
                    if (list.size() == counts) continue;
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(list);
                    newList.add(count);
                    arr[i].add(newList);
                }
            }
        }
    }

}
