package com.zipcodewilmington.arrayutility;



        import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

        import java.lang.reflect.Array;
        import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] myArray;

    public ArrayUtility(T[] myArray) {
        this.myArray = myArray;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer count = 0;

        for (T n : arrayToMerge) {
            if(n==valueToEvaluate) {
                count++;
            }
        }
//        for(T n:myArray){
//            if(n==valueToEvaluate){
//                count++;
//            }
//        } in this case return count;

        return count+getNumberOfOccurrences(valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        ArrayList<T> merged = new ArrayList<>();
        for (int i = 0; i < myArray.length; i++) {
            merged.add(myArray[i]);
        }
        for (int i = 0; i < arrayToMerge.length; i++) {
            merged.add(arrayToMerge[i]);
        }

        T popular = merged.get(0);
        Integer count = 0;
        Integer tempCount = 0;
        for (int i = 0; i <merged.size() ; i++) {
            tempCount = getNumberOfOccurrences(merged.get(i));

            if (tempCount > count) {
                popular = merged.get(i);
                count = tempCount;
                tempCount=0;
            }

        }

        return popular;

    }


    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T n : myArray) {
            if (n == valueToEvaluate) {
                count++;
            }
        }

        return count;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> removed = new ArrayList<>();
        for(T n:myArray){
            if(n!=valueToRemove){
                removed.add(n);
            }
        }
        return  removed.toArray(Arrays.copyOf(myArray,removed.size()));
    }
}