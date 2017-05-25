package org.yadavvi.combinationofnumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 24/5/17.
 */
public class CombinationOfNumbers {

    public static void main(String[] args) {
        combination(18, 3);
        combinationWithRecursion(18, 3);
    }

    private static void combinationWithRecursion(int value, int maxCombinations) {
        int endValue = value;
        int startValue = 0;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        combinationWithRecursion(startValue, endValue, maxCombinations, list, finalList);
        System.out.println("combinationWithRecursion: " + finalList);
    }

    private static void combinationWithRecursion(int value, int endValue, int maxCombinations, List<Integer> list,
                                                 List<List<Integer>> finalList) {
        if (value < 0 || value > endValue) return;
        if (value == endValue) {
            if (list.size() <= maxCombinations) finalList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= endValue; i++) {
            if (value + i > endValue) break;
            list.add(i);
            combinationWithRecursion(value + i, endValue, maxCombinations, list, finalList);
            list.remove(list.size() - 1);
        }
    }

    private static void combination(int value, int maxCombinations) {
        List<List<Integer>>[] arr = new List[value + 1];
        arr[0] = new ArrayList<>();
        arr[0].add(new ArrayList<>());
        combination(value, maxCombinations, arr);
        System.out.println("combination             : " + arr[value]);
    }

    private static void combination(int value, int maxCombinations, List<List<Integer>>[] arr) {
        for (int i = 1; i <= value; i++) {
            arr[i] = new ArrayList<>();
            for (int count = 0; count <= value; count++) {
                if (i - count < 0) break;

                for (List<Integer> list : arr[i - count]) {
                    if (list.size() == maxCombinations) continue;
                    List<Integer> newList = new ArrayList<>();
                    newList.add(count);
                    newList.addAll(list);
                    arr[i].add(newList);
                }
            }
        }
    }

}
