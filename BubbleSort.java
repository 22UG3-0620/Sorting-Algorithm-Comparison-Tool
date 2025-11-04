import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public static class Result {
        public List<Integer> sortedList;
        public double timeMs;
        public int steps;
    }

    public static Result sort(List<Integer> arr) {
        Result result = new Result();
        List<Integer> list = new java.util.ArrayList<>(arr);
        long start = System.nanoTime();
        int steps = 0;
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }

        long end = System.nanoTime();
        result.sortedList = list;
        result.timeMs = (end - start) / 1e6;
        result.steps = steps;
        return result;
    }
}
