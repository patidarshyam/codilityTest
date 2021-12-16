package com.sp.sorting;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0

<img src='disc.png' />

There are eleven (unordered) pairs of discs that intersect, namely:

        discs 1 and 4 intersect, and both intersect with all the other discs;
        disc 2 also intersects with discs 0 and 3.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Assume that:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [0..2,147,483,647].

Complexity:

        expected worst-case time complexity is O(N*log(N));
        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified
 * 
 * @author Shyam
 *
 */
public class NumberOfDiscIntersections {

	/**
	 * Compute the number of intersections in a sequence of discs.
	 */
	public int solution(int[] A) {
        final int N = A.length;
        
        if (N < 2) {
            return 0;
        }

        long[] leftEdges = new long[N];
        long[] rightEdges = new long[N];

        for (int i = 0; i < N; i++) {
            long r = (long)A[i];
            
            long left = i - r;
            leftEdges[i] = left;

            long right = i + r;
            rightEdges[i] = right;
        }

        quicksort(leftEdges, 0, N - 1);
        quicksort(rightEdges, 0, N - 1);

        int counter = 0;
        int previousCircles = 0;
        int leftP = 0;

        for (int rightP = 0; rightP < N; rightP++) {
            while ((leftP < N) && (leftEdges[leftP] <= rightEdges[rightP])) {
                leftP++;
                previousCircles++;
            }

            counter += --previousCircles;

            if (counter > 10000000) {
                return -1;
            }
        }
        return counter;
    }

    private void quicksort(long arr[], int left, int right) {
        int index = partition(arr, left, right);
        
        if (left < index - 1) {
            quicksort(arr, left, index - 1);
        }

        if (index < right) {
            quicksort(arr, index, right);
        }
    }

    private int partition(long arr[], int left, int right) {
        long pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                long tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }

        return left;
    }
}
