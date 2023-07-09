import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class FirstNonRepete {
    public static String FirstNonRepeating(String A) {
        int n = A.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Queue<Character> qu = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
                qu.add(ch);
            }

            while (!qu.isEmpty() && map.get(qu.peek()) > 1) {
                qu.remove();
            }

            if (qu.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(qu.peek());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "aabc";
        String result = FirstNonRepeating(A);
        System.out.println(result);

        A = "zz";
        result = FirstNonRepeating(A);
        System.out.println(result);
    }
}
