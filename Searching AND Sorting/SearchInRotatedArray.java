class SearchInRotatedArray
{
    int search(int arr[], int l, int h, int key)
    {
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] == key)
                return mid;

            if (arr[mid] >= arr[l]) {
                if (key >= arr[l] && key < arr[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (key > arr[mid] && key <= arr[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedArray solution = new SearchInRotatedArray();

        int[] arr = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int n = arr.length;
        int key = 6;

        int result = solution.search(arr, 0, n - 1, key);

        if (result != -1) {
            System.out.println("Element " + key + " found at index " + result);
        } else {
            System.out.println("Element " + key + " not found in the array.");
        }
    }
}
