//8
public class PairDifference
{
    public static boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);

        int i = 0;
        int j = 1;

        while (i < size && j < size) {
            if (i != j && arr[j] - arr[i] == n) {
                return true;
            } else if (arr[j] - arr[i] < n) {
                j++;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int arr[] = { 4, 2, 6, 8, 10, 12 };
        int size = arr.length;
        int n = 2;

        boolean found = findPair(arr, size, n);

        if (found) {
            System.out.println("A pair with a difference of " + n + " exists in the array.");
        } else {
            System.out.println("No pair with a difference of " + n + " exists in the array.");
        }
    }
}
