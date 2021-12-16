package com.sp;

import com.sp.arrays.CyclicRotation;
import com.sp.arrays.MissingSmallestPositiveNum;
import com.sp.arrays.OddOccurencesInArray;
import com.sp.iterations.BinaryGap;
import com.sp.sorting.Distinct;
import com.sp.sorting.MaxProductOfThree;
import com.sp.sorting.NumberOfDiscIntersections;
import com.sp.sorting.Triangle;
import com.sp.timecomplexity.FrogJump;
import com.sp.timecomplexity.PermMissingElem;

public class ApplicationMain {

	public static void main(String[] args) {

		
		  BinaryGap binaryGap = new BinaryGap(); System.out.println("binaryGap : "+
		  binaryGap.findLongestSeqOfZeros(529));
		  
		  CyclicRotation cyclicRotation = new CyclicRotation(); int [] a = new int[]
		  {-3, 8, 9, -7, 6}; cyclicRotation.rotateArray(a, a.length, 5);
		  
		  int [] arr = new int[]{3, 8, 8,9, 3,9, 6}; OddOccurencesInArray
		  oddOccurencesInArray = new OddOccurencesInArray();
		  oddOccurencesInArray.findOddOccurencesInArray(arr, arr.length);
		  
		  Distinct distinct = new Distinct(); distinct.countDistinctInArray(arr);
		  
		  MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
		  maxProductOfThree.getMaxProductOfThree(arr);
		  System.out.println("MaxProductOfThree"+maxProductOfThree.solution(arr));
		  
		  int [] arr1 = new int[]{1,5,2,1,4,0}; NumberOfDiscIntersections
		  noOfDistIntersections = new NumberOfDiscIntersections();
		  System.out.println("noOfDistIntersections: "+noOfDistIntersections.solution(
		  arr1));
		  
		  int [] arrT = new int[]{10,2,5,1,8,20}; Triangle triangle=new Triangle();
		  System.out.println("triangle: "+triangle.solution(arrT));
		  
		  FrogJump frogJump=new FrogJump();
		  System.out.println("total jumps: "+frogJump.jumpRequired(10, 85, 0));
		  
		  
		  
		  int [] arrM = new int[] {1,3,6,4,1,2}; //{3,4,5,1,6,2};
		  PermMissingElem  permMissingElem=new PermMissingElem();
		  System.out.println("missing element:"+permMissingElem.findMissingNo(arrM));
		 

		MissingSmallestPositiveNum obj = new MissingSmallestPositiveNum();
		int arrMs[] = { 12, 3, 7, 6, 8, -1, -10, 15 };
		int arr_size = arrMs.length;

		int missing = obj.findMissingNo(arrMs, arr_size);

		System.out.println("The smallest positive" + " missing number is " + missing);
	}

}
