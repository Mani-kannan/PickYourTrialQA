import java.util.*;
import java.util.stream.Stream;

public class SuperStack {

   private static void superStack(String[] operations) {
        //initialize the stack list
        List<Integer> stack = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //loop the operations
        Arrays.stream(operations).forEach(operation -> {
            if (operation.startsWith("push")) {
                int currentValue = Integer.parseInt(operation.split(" ")[1]);
                stack.add(currentValue);
            } else if (operation.startsWith("pop")) {
                stack.remove(stack.size() - 1);
                //modify the hashmap
                for (Integer i : map.keySet()) {
                    if (stack.size() < i) {
                        map.put(i - 1, map.get(i));
                        map.remove(i);
                    }
                }
            } else if (operation.startsWith("inc")) {
                String[] splits = operation.split(" ");
                int e = Integer.parseInt(splits[1]);
                int currentValue = Integer.parseInt(splits[2]);
                map.put(e, map.getOrDefault(e, 0) + currentValue);
            }

            if (stack.size() == 0) {
                System.out.println("EMPTY");
            } else {
                int currentValue = stack.get(stack.size() - 1);
                for (Integer i : map.keySet()) {
                    if (stack.size() <= i) {
                        currentValue += map.get(i);
                    }
                }
                System.out.println(currentValue);
            }
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalOperations = Integer.parseInt(scanner.nextLine());
        String[] operations = new String[totalOperations];
        Stream.iterate(0, x -> x + 1).limit(totalOperations).forEach(element -> {
            operations[element] = scanner.nextLine();
        });
        superStack(operations);
    }

}
