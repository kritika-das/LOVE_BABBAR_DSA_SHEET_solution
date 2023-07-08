// 28
class triplets {
    
    long maxProduct(int[] arr, int n) {
        
        long maxProduct = arr[0];
        long maxEndingHere = arr[0];
        long minEndingHere = arr[0];
        
        for (int i = 1; i < n; i++) {
            
            if (arr[i] < 0) {
                long temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }
            
            maxEndingHere = Math.max(arr[i], maxEndingHere * arr[i]);
            minEndingHere = Math.min(arr[i], minEndingHere * arr[i]);
           
            maxProduct = Math.max(maxProduct, maxEndingHere);
        }
        
        return maxProduct;
    }
    // Main function to test the maxProduct method
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {6, -3, -10, 0, 2};
        int n = arr.length;

        long maxProduct = solution.maxProduct(arr, n);
        System.out.println("Product of maximum product subarray: " + maxProduct);
    }
}
