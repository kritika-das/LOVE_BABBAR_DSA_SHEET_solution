class Solution {
    int middle(int A, int B, int C) {
        if (A > B) {
            if (B > C)
                return B;
            else {
                if (A > C)
                    return C;
                else
                    return A;
            }
        } else {
            if (A > C)
                return A;
            else {
                if (B < C)
                    return B;
                else
                    return C;
            }
        }
    }
}

public class MiddleOfThree {
    public static void main(String[] args) {
        int A = 10, B = 5, C = 15;
        Solution solution = new Solution();
        int result = solution.middle(A, B, C);
        System.out.println("The middle of three numbers is: " + result);
    }
}
