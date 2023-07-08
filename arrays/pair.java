
// 18
public class pair {
  
    int getPairsCount(int[] arr, int n, int k) {
       
        Map<Integer, Integer> freqMap = new HashMap<>();
        int pairCount = 0;

        for (int i = 0; i < n; i++) {
            int complement = k - arr[i];

            
            if (freqMap.containsKey(complement)) {
                pairCount += freqMap.get(complement);
            }

            
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        return pairCount;
    }

    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = {1, 5, 7, 1};
        int n = arr.length;
        int k = 6;

        int pairCount = solution.getPairsCount(arr, n, k);
        System.out.println("Number of pairs: " + pairCount);
    }
}


