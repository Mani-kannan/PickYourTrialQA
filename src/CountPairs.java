import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountPairs {

   private static Integer countPairs(int differenceValue, List<Integer> elementsArray) {
        HashSet<Integer> elementSet = new HashSet<>();
        HashSet<Integer> elementSetWithDifference = new HashSet<>();
        elementsArray.forEach(element -> {
            elementSet.add(element);
            elementSetWithDifference.add(element + differenceValue);
        });
        return elementSetWithDifference.stream().filter(elementSet::contains).collect(Collectors.toList()).size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = Integer.parseInt(scanner.nextLine());
        Integer[] elementsArray = new Integer[arrayLength];
        Stream.iterate(0, x -> x + 1).limit(arrayLength).forEach(element -> {
            elementsArray[element] = Integer.parseInt(scanner.nextLine());
        });
        int differenceValue = Integer.parseInt(scanner.nextLine());
        int totalPairCount = countPairs(differenceValue, Arrays.asList(elementsArray));
        System.out.println(totalPairCount);
    }

}
