//15
class MinimumSwaps
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[])
    {
        // Code here
        int ans = 0;
        int n = arr.length;
        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);
        Map<Integer, Integer> h = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            h.put(arr[i], i);
        }
        
        int init = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                init = arr[i];

                // Swap elements
                int tempIndex = h.get(temp[i]);
                arr[i] = arr[tempIndex];
                arr[tempIndex] = init;

                // Update the positions in the map
                h.put(init, tempIndex);
                h.put(temp[i], i);
            }
        }
        
        return ans;
    }
}
