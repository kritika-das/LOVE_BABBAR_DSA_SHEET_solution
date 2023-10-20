// 13 product array
class ProductArray {
    public static long[] productExceptSelf(int[] nums, int n) {
        long[] result = new long[n];
        long[] leftProduct = new long[n];
        long[] rightProduct = new long[n];

        leftProduct[0] = 1;
        rightProduct[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }
}
