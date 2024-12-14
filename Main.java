import java.util.Scanner;

class Main {
    // Method to allocate memory to
    // blocks as per First fit algorithm
    static void firstFit(int blockSize[], int m,
                         int processSize[], int n) {
        // Stores block id of the
        // block allocated to a process
        int allocation[] = new int[n];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    // allocate block j to p[i] process
                    allocation[i] = j;

                    // Reduce available memory in this block.
                    blockSize[j] -= processSize[i];

                    break;
                }
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t" +
                             processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input block sizes
        System.out.println("Enter the number of blocks:");
        int m = scanner.nextInt();
        int[] blockSize = new int[m];
        System.out.println("Enter block sizes:");
        for (int i = 0; i < m; i++) {
            blockSize[i] = scanner.nextInt();
        }

        // Input process sizes
        System.out.println("Enter the number of processes:");
        int n = scanner.nextInt();
        int[] processSize = new int[n];
        System.out.println("Enter process sizes:");
        for (int i = 0; i < n; i++) {
            processSize[i] = scanner.nextInt();
        }

        firstFit(blockSize, m, processSize, n);

        scanner.close();
    }
}