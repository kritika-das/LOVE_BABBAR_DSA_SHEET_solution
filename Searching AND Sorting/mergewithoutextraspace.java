//11
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
         int i = n - 1;
        int j = 0;
        
        while (i >= 0 && j < m && arr1[i] > arr2[j]) {
            swap(arr1, i, arr2, j);
            i--;
            j++;
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    
   static void swap(long[] arr1, int i, long[] arr2, int j) {
        long temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
}
