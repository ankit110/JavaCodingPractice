package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        // using lambda expression
        Arrays.asList(new String[] {
                "Ankit", "Ayush", "Abhijeet", "Anmol", "Manish", "Prashant", "Vaibhav"
        }).stream()
                .filter(s -> s.startsWith("A"))
                .map(s -> s.toLowerCase())
                .sorted() // filter, map(stateless), sorted(stateful) are intermediate operation
                .forEach(s -> System.out.println(s)); // Terminal operation.

        // using Method Reference.
        Arrays.stream(new String[] {
                        "Ankit", "Ayush", "Abhijeet", "Anmol", "Manish", "Prashant", "Vaibhav"
                })
                .filter(s -> s.startsWith("A"))
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);

        Arrays.asList(1, 2, 3, 4, 1, 2,3 ,4)
                .stream()
                .distinct()
                .forEach(number -> System.out.println(number));

        Arrays.asList(1, 2, 3, 4, 1, 2,3 ,4)
                .stream()
                .distinct()
                .forEach(StreamMain::print); // Custom Method reference.


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6);

        List<Integer> updatedList = list.stream().distinct()
                .toList();

        System.out.println(updatedList);

        List<String> nameList = Arrays.asList("Ankit", "Ayush", "Abhijeet", "Anmol", "Manish", "Vaibhav");

        List<String> nameStartsWithA = nameList.stream().filter(s -> s.startsWith("A"))
                                                        .sorted()
                                                        .collect(Collectors.toList());

        System.out.println(nameStartsWithA);
    }

    public static void print(Integer num) {
        System.out.println(num);
    }

}
