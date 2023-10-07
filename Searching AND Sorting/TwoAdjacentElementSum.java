//9
public class TwoAdjacentElementSum {
    public int FindMaxSum(int arr[], int n) {
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int[] cache = new int[n];
        cache[0] = arr[0];
        cache[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            cache[i] = Math.max(cache[i - 1], cache[i - 2] + arr[i]);
        }

        return cache[n - 1];
    }

    public static void main(String[] args) {
        TwoAdjacentElementSum solution = new TwoAdjacentElementSum();
        
        int[] arr = {2, 7, 9, 3, 1};
        int n = arr.length;

        int maxSum = solution.FindMaxSum(arr, n);

        System.out.println("The maximum sum of a subsequence with no adjacent elements is: " + maxSum);
    }
}
