//7
import java.util.Scanner;

class MajorityElement {
    static int majorityElement(int a[], int size) {
        int count = 0;
        int candidate = 0;

        for (int i = 0; i < size; i++) {
            int num = a[i];

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Check if the candidate is the majority element
        count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == candidate) {
                count++;
            }
        }

        return count > size / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int result = majorityElement(a, n);
        if (result != -1) {
            System.out.println("The majority element is: " + result);
        } else {
            System.out.println("There is no majority element in the array.");
        }
    }
}
