import java.util.ArrayList;
import java.util.List;

public class MergeSort {

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
        mergeSort(list, 0, list.size() - 1, counter);
        long end = System.nanoTime();

        result.sortedList = list;
        result.timeMs = (end - start) / 1e6;
        result.steps = counter.count;
        return result;
    }

    private static void mergeSort(List<Integer> arr, int left, int right, StepCounter counter) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, counter);
            mergeSort(arr, mid + 1, right, counter);
            merge(arr, left, mid, right, counter);
        }
    }

    private static void merge(List<Integer> arr, int left, int mid, int right, StepCounter counter) {
        List<Integer> L = new ArrayList<>(arr.subList(left, mid + 1));
        List<Integer> R = new ArrayList<>(arr.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < L.size() && j < R.size()) {
            counter.count++;
            if (L.get(i) <= R.get(j)) {
                arr.set(k++, L.get(i++));
            } else {
                arr.set(k++, R.get(j++));
            }
        }
        while (i < L.size()) arr.set(k++, L.get(i++));
        while (j < R.size()) arr.set(k++, R.get(j++));
    }
}
