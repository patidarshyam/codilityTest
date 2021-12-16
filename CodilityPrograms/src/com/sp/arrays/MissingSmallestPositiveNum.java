package com.sp.arrays;

public class MissingSmallestPositiveNum {

	public int findMissingNo(int []arr, int n)
    {
        // to store current array element
        int val;
     
        // to store next array element in
        // current traversal
        int nextval;
     
        for (int i = 0; i < n; i++) {
     
            // if value is negative or greater
            // than array size, then it cannot
            // be marked in array. So move to
            // next element.
            if (arr[i] <= 0 || arr[i] > n)
                continue;
     
            val = arr[i];
     
            // traverse the array until we
            // reach at an element which
            // is already marked or which
            // could not be marked.
            while (arr[val - 1] != val) {
                nextval = arr[val - 1];
                arr[val - 1] = val;
                val = nextval;
                if (val <= 0 || val > n)
                    break;
            }
        }
     
        // find first array index which is
        // not marked which is also the
        // smallest positive missing
        // number.
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
     
        // if all indices are marked, then
        // smallest missing positive
        // number is array_size + 1.
        return n + 1;
    }
}
