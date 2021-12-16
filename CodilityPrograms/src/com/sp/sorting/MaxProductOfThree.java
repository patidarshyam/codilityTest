package com.sp.sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6

contains the following example triplets:

        (0, 1, 2), product is −3 * 1 * 2 = −6
        (1, 2, 4), product is 1 * 2 * 5 = 10
        (2, 4, 5), product is 2 * 5 * 6 = 60

Your goal is to find the maximal product of any triplet.

Write a function:

    class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6

the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Assume that:

        N is an integer within the range [3..100,000];
        each element of array A is an integer within the range [−1,000..1,000].

Complexity:

        expected worst-case time complexity is O(N*log(N));
        expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.


 * @author Shyam
 *
 */
public class MaxProductOfThree {

	/**
	 * Maximize A[P]*A[Q]*A[R] for any triplet (P, Q, R).
	 */
	public int getMaxProductOfThree(int[] A) {
		ArrayList<Integer> list = new ArrayList<>();
		 
        for (int integer : A) {
        	list.add(integer);
		}
        Collections.sort(list);
        
        System.out.println("list :"+list);
        int result = list.get(list.size()-1)*list.get(list.size()-2)*list.get(list.size()-3);
        System.out.println("result :"+result);
		return result;
	}
	public int solution(int[] A) {
        int N = A.length;
        quicksort(A, 0, N - 1);

        int tmp1 = (A[0] * A[1]);
        int tmp2 = (A[N - 2] * A[N - 3]);

        if (A[N - 1] > 0) {
            return A[N - 1] * ((tmp1 > tmp2) ? tmp1 : tmp2);
        } else {
            return A[N - 1] * ((tmp1 < tmp2) ? tmp1 : tmp2);
        }
    }

    private void quicksort(int arr[], int left, int right) {
        int index = partition(arr, left, right);

        if (left < index - 1) {
            quicksort(arr, left, index - 1);
        }

        if (index < right) {
            quicksort(arr, index, right);
        }
    }

    private int partition(int arr[], int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {    
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }

        return left;
    }
}
