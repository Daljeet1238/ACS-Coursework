/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    
    public static <K extends Comparable<K>> void mergesort(K[] array){
        mergeSort(array, new DefaultComparator<K>());
    }

    public static <K> void mergeSort(K[] S, Comparator<K> comp){
        int n = S.length;
        if(n < 2) return;

        //divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);             // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);             // copy of second half

        //conquer (with recursion)
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        //merge results
        merge(S1, S2, S, comp);
    }

    public static <K> void merge(K[] S1, K[] S2, K[]S, Comparator<K> comp){
        int i = 0, j = 0;
        while(i + j < S.length){
            if(j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)){
                S[i + j] = S1[i++];
            }else{
                S[i + j] = S2[j++];
            }
        }
    }
}
