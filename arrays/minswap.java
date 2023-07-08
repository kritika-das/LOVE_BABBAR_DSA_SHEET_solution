// 33
class minswap {
    public static int minSwap(int arr[], int n, int k) {
        int count = 0; 
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }

       
        int windowCount = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                windowCount++;
            }
        }

        int minSwaps = windowCount; 

        
        for (int i = 0, j = count; j < n; i++, j++) {
            
            if (arr[i] > k) {
                windowCount--;
            }

            if (arr[j] > k) {
                windowCount++;
            }

            
            minSwaps = Math.min(minSwaps, windowCount);
        }

        return minSwaps;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 1, 5, 6, 3};
        int k1 = 3;
        int n1 = arr1.length;
        System.out.println("Minimum Swaps required for arr1: " + minSwap(arr1, n1, k1));

        int arr2[] = {2, 7, 9, 5, 8, 7, 4};
        int k2 = 6;
        int n2 = arr2.length;
        System.out.println("Minimum Swaps required for arr2: " + minSwap(arr2, n2, k2));
    }
}

