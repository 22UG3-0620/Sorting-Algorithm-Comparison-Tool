import java.util.*;

public class Final {

    private static List<Integer> data = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandomNumbers();
                case 3 -> performBubbleSort();
                case 4 -> performMergeSort();
                case 5 -> performQuickSort();
                case 6 -> compareAll();
                case 7 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

     private static void enterNumbers() {
    data.clear();
    System.out.println("Enter numbers separated by spaces:");
    String line = scanner.nextLine().trim();

    // If the line is empty, ask again
    if (line.isEmpty()) {
        line = scanner.nextLine().trim();
    }

    String[] parts = line.split("\\s+");
    for (String p : parts) {
        try {
            data.add(Integer.parseInt(p.trim()));
        } catch (NumberFormatException ignored) {}
    }

    System.out.println("Data loaded: " + data);
}

    private static void generateRandomNumbers() {
        data.clear();
        System.out.print("Enter number of elements to generate: ");
        int n = getIntInput();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data.add(rand.nextInt(100));
        }
        System.out.println("Generated data: " + data);
    }

    private static void performBubbleSort() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please input or generate data first.");
            return;
        }
        BubbleSort.Result result = BubbleSort.sort(data);
        System.out.println("Bubble Sorted: " + result.sortedList);
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.timeMs, result.steps);
    }

    private static void performMergeSort() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please input or generate data first.");
            return;
        }
        MergeSort.Result result = MergeSort.sort(data);
        System.out.println("Merge Sorted: " + result.sortedList);
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.timeMs, result.steps);
    }

    private static void performQuickSort() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please input or generate data first.");
            return;
        }
        QuickSort.Result result = QuickSort.sort(data);
        System.out.println("Quick Sorted: " + result.sortedList);
        System.out.printf("Time: %.3f ms | Steps: %d%n", result.timeMs, result.steps);
    }

    private static void compareAll() {
        if (data.isEmpty()) {
            System.out.println("No data available. Please input or generate data first.");
            return;
        }

        BubbleSort.Result bubble = BubbleSort.sort(data);
        MergeSort.Result merge = MergeSort.sort(data);
        QuickSort.Result quick = QuickSort.sort(data);

        System.out.println("\n-----------------------------------------------");
        System.out.println("Algorithm      | Time (ms) | Step Count");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-14s | %8.3f | %d%n", "Bubble Sort", bubble.timeMs, bubble.steps);
        System.out.printf("%-14s | %8.3f | %d%n", "Merge Sort", merge.timeMs, merge.steps);
        System.out.printf("%-14s | %8.3f | %d%n", "Quick Sort", quick.timeMs, quick.steps);
        System.out.println("-----------------------------------------------");
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}
 