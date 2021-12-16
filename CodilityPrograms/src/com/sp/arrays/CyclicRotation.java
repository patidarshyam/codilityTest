package com.sp.arrays;

/**
A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.

For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.

Write a function:

Results solution(int A[], int N, int K);

that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 * @author Shyam
 *
 */
public class CyclicRotation {

	/**
	 * Rotate an array to the right by a given number of steps.
	 */
	public int[] rotateArray(int a[], int size, int k) {
		if(k>size || k<=0) {
			System.out.println("Please enter correct rotation value.");
			return null;
		}
		int [] rotatedArray = new int[size];
		int j=0;
		for(int i=k-1; i<size; i++) {
			rotatedArray[j]=a[i];
			j++;
		}
		for(int i=0; i<k-1; i++) {
			rotatedArray[j]=a[i];
			j++;
		}
		System.out.print("old array :");
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.print("\nnew array :");
		for (int i : rotatedArray) {
			System.out.print(i+" ");
		}
		return rotatedArray;
	}
	
}
