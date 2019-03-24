import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MinimumUniqueArraySum {

    static int getMinimumUniqueSum(int[] arr) {
        int sum;
        ArrayList<Integer> arrayList = new ArrayList<>(arr.length);
        arrayList.add(arr[0]);

        Arrays.stream(arr).skip(1).forEach(element -> {
            int currentElement = element;
            while (arrayList.contains(currentElement)) currentElement++;
            arrayList.add(currentElement);
        });
        sum = arrayList.stream().mapToInt(d -> d).sum();
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = Integer.parseInt(scanner.nextLine());
        int[] elementsArray = new int[arrayLength];
        Stream.iterate(0, x -> x + 1).limit(arrayLength).forEach(element -> {
            elementsArray[element] = Integer.parseInt(scanner.nextLine());
        });
        int sum = getMinimumUniqueSum(elementsArray);
        System.out.println(sum);
    }

}
