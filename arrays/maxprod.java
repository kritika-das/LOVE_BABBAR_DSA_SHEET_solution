// 20
class maxprod {
    public int maxProductSubarray(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int maxResult = arr[0];
        
        for (int i = 1; i < n; i++) {
            int tempMax = Math.max(arr[i], Math.max(maxProduct * arr[i], minProduct * arr[i]));
            int tempMin = Math.min(arr[i], Math.min(maxProduct * arr[i], minProduct * arr[i]));
            
            maxProduct = tempMax;
            minProduct = tempMin;
            
            maxResult = Math.max(maxResult, maxProduct);
        }
        
        return maxResult;
    }

    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 4, 5, -1, 0};

        int maxProduct = solution.maxProductSubarray(arr);
        System.out.println("Product of maximum product subarray: " + maxProduct);
    }
}
