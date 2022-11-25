package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] arr;

    public ArrayUtility(T[] arr) {
        this.arr = arr;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int count = 0;
        for (T ele : arr) {
            if (ele.equals(valueToEvaluate)) {
                count++;
            }
        }
        for (T ele : arrayToMerge) {
            if (ele.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int count = 0;
        T mostCommon = null;
        Map <T, Integer> freq = new HashMap<>();
        for (T ele : arr) {
            //updates map with key for every element and update the count of a value + 1
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
            int currentCount = freq.get(ele);
            if (currentCount > count) {
                count = currentCount;
                mostCommon = ele;
            }
        }

        for (T ele : arrayToMerge) {
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
            int currentCount = freq.get(ele);
            if (currentCount > count) {
                count = currentCount;
                mostCommon = ele;
            }
        }
        return mostCommon;
    }

    public int getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (T ele : arr) {
            if (ele.equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }
    public T[] removeValue(T valueToRemove) {
        //take getNumOfOcc to remove
        int removeCount = getNumberOfOccurrences(valueToRemove);
        int count = 0;
        T[] arrWithRemovedEle = Arrays.copyOf(this.arr, this.arr.length - removeCount);
        for (T ele : arr) {
            if (ele != valueToRemove) {
                //element copying is the index of count
                arrWithRemovedEle[count++] = ele;
            }
        }
        return arrWithRemovedEle;
    }
}
