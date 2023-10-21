//

import java.util.*;

class Compute {
    static void sortBySetBitCount(Integer arr[], int n) {
        Arrays.sort(arr, (i1, i2) -> {
            return Integer.bitCount(i2) - Integer.bitCount(i1);
        });
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 8, 7, 1};
        int n = arr.length;

        System.out.println("Original Array: " + Arrays.toString(arr));

        sortBySetBitCount(arr, n);

        System.out.println("Sorted Array by Set Bit Count: " + Arrays.toString(arr));
    }
}
