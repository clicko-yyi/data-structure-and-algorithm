package offer;


public class O11 {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        int pivot;
        while (low < high) {
            pivot = low + ((high - low) >> 1);
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high = high - 1;
            }
        }
        return numbers[low];
    }

    public int minArray_solution_2(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] <= numbers[i + 1]) {
                continue;
            } else {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}
