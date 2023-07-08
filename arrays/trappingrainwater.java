//29

public class trappingrainwater {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {
        if (n <= 2) {
            return 0; 
        }

        long waterTrapped = 0;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                } else {
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }

   
    public static void main(String[] args) {
        int arr[] = {3, 0, 0, 2, 0, 4};
        int n = arr.length;

        long trappedWater = trappingWater(arr, n);
        System.out.println("Trapped Water: " + trappedWater);
    }
}


