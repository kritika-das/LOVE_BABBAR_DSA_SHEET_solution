//25
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Anary {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // Create a map to store values from array A
        Map<Integer, Stack<Integer>> m = new HashMap<>();
        
        // Populate the map with values from array A
        for (int i = 0; i < 2 * e; i += 2) {
            int key = A[i];
            int value = A[i + 1];
            
            // If the key is not in the map, create a new stack for it
            m.putIfAbsent(key, new Stack<>());
            
            // Push the value onto the stack associated with the key
            m.get(key).push(value);
        }
        
        // Iterate through array B
        for (int i = 0; i < 2 * e; i += 2) {
            int key = B[i];
            int expectedValue = B[i + 1];
            
            // If the key is not in the map or the top of the stack doesn't match the expected value, return 0
            if (!m.containsKey(key) || m.get(key).isEmpty() || m.get(key).pop() != expectedValue) {
                return 0;
            }
        }
        
        // If all checks passed, return 1
        return 1;
    }

    public static void main(String[] args) {
        // Example input data
        int n = 3;
        int e = 3;
        int[] A = {1, 2, 1, 3, 2, 4};
        int[] B = {1, 3, 2, 4, 1, 2};
        
       
