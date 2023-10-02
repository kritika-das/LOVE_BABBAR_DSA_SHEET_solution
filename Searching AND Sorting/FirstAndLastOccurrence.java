import java.util.ArrayList;

public class FirstAndLastOccurrence {

    int bin_search_first(int arr[], int n, int x) {
        int l = 0;
        int h = n - 1;
        int first = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == x) {
                first = mid;
                h = mid - 1;
            } else if (arr[mid] > x) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return first;
    }

    int bin_search_last(int arr[], int n, int x) {
        int l = 0;
        int h = n - 1;
        int last = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == x) {
                last = mid;
                l = mid + 1;
            } else if (arr[mid] > x) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return last;
    }

    ArrayList<Integer> find(int arr[], int n, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int first = bin_search_first(arr, n, x);
        int last = bin_search_last(arr, n, x);
        ans.add(first);
        ans.add(last);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 4, 5, 5, 5, 6 };
        int n = arr.length;
        int x = 5;

        FirstAndLastOccurrence finder = new FirstAndLastOccurrence();
        ArrayList<Integer> result = finder.find(arr, n, x);

        int firstOccurrence = result.get(0);
        int lastOccurrence = result.get(1);

        if (firstOccurrence != -1 && lastOccurrence != -1) {
            System.out.println("First occurrence of " + x + " is at index: " + firstOccurrence);
            System.out.println("Last occurrence of " + x + " is at index: " + lastOccurrence);
        } else {
            System.out.println(x + " not found in the array.");
        }
    }
}
