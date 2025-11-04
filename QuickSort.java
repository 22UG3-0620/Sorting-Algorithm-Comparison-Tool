import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    public static class StepCounter {
        int count = 0;
    }

    public static class Result {
        public List<Integer> sortedList;
        public double timeMs;
        public int steps;
    }

    public static Result sort(List<Integer> arr) {
        Result result = new Result();
        List<Integer> list = new ArrayList<>(arr);
        StepCounter counter = new StepCounter();

        long start = System.nanoTime();
        quickSort(list, 0, list.size() - 1, counter);
        long end = System.nanoTime();

        result.sortedList = list;
        result.timeMs = (end - start) / 1e6;
        result.steps = counter.count;
        return result;
    }

    private static void quickSort(List<Integer> arr, int low, int high, StepCounter counter) {
        if (low < high) {
            int pi = partition(arr, low, high, counter);
            quickSort(arr, low, pi - 1, counter);
            quickSort(arr, pi + 1, high, counter);
        }
    }

    private static int partition(List<Integer> arr, int low, int high, StepCounter counter) {
        int pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            counter.count++;
            if (arr.get(j) < pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }
}
