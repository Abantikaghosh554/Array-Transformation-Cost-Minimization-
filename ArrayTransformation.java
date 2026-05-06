import java.util.*;

public class ArrayTransformation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        long[] A = new long[N];

        System.out.println("Enter array elements:");
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        System.out.print("Enter K: ");
        long K = sc.nextLong();

        // Step 1: Check feasibility
        for (int i = 1; i < N; i++) {
            if ((A[i] - A[0]) % K != 0) {
                System.out.println(-1);
                return;
            }
        }

        // Step 2: Convert array
        long[] B = new long[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[i] / K;
        }

        // Step 3: Sort and find median
        Arrays.sort(B);
        long median = B[N / 2];

        // Step 4: Calculate operations
        long operations = 0;
        for (int i = 0; i < N; i++) {
            operations += Math.abs(B[i] - median);
        }

        System.out.println("Minimum operations: " + operations);
    }
}