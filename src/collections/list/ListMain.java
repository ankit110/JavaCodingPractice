package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMain {
    public static void main(String... args) {
        List<Cricketer> cricketers = new ArrayList<>();

        cricketers.add(new Cricketer("Don Bradman", 9996));
        cricketers.add(new Cricketer("Sachin", 14000));
        cricketers.add(new Cricketer("Dravid", 12000));
        cricketers.add(new Cricketer("pointing", 11000));

        System.out.println(cricketers);

//        Collections.sort(cricketers); // Compiler error

        // We are able to sort numbers because String implements Comparable Interface.

        // Now we have implement Comparable interface

        Collections.sort(cricketers);

        System.out.println(cricketers);

        Collections.sort(cricketers, new DescendingSorter());

        System.out.println(cricketers);
    }
}
