// DO NOT MODIFY THIS CLASS

import java.util.Collection;
import java.util.List;

public class CollectionUtilsTest {
    public static void main(String[] args) {
        testAverage();
        testMaxLength();
        testContainsDuplicate();
    }

    private static void testAverage() {
        System.out.println("Testing average");

        Collection<Integer> collection1 = List.of(6);
        System.out.println(CollectionUtils.average(collection1)); // 6.0

        Collection<Integer> collection2 = List.of(6, 5);
        System.out.println(CollectionUtils.average(collection2)); // 5.5

        Collection<Integer> collection3 = List.of(6, 5, 4);
        System.out.println(CollectionUtils.average(collection3)); // 5.0

        System.out.println();
    }

    private static void testMaxLength() {
        System.out.println("Testing maxLength");

        Collection<String> collection1 = List.of("one");
        System.out.println(CollectionUtils.maxLength(collection1)); // 3

        Collection<String> collection2 = List.of("one", "two");
        System.out.println(CollectionUtils.maxLength(collection2)); // 3

        Collection<String> collection3 = List.of("one", "two", "three");
        System.out.println(CollectionUtils.maxLength(collection3)); // 5

        Collection<String> collection4 = List.of("one", "two", "three", "four");
        System.out.println(CollectionUtils.maxLength(collection4)); // 5

        System.out.println();
    }

    private static void testContainsDuplicate() {
        System.out.println("Testing containsDuplicate");

        Collection<Integer> collection0 = List.of();
        System.out.println(CollectionUtils.containsDuplicate(collection0)); // false

        Collection<Integer> collection1 = List.of(1);
        System.out.println(CollectionUtils.containsDuplicate(collection1)); // false

        Collection<Integer> collection2 = List.of(1, 2, 3);
        System.out.println(CollectionUtils.containsDuplicate(collection2)); // false

        Collection<Integer> collection3 = List.of(1, 1);
        System.out.println(CollectionUtils.containsDuplicate(collection3)); // true

        Collection<Integer> collection4 = List.of(1, 2, 1);
        System.out.println(CollectionUtils.containsDuplicate(collection4)); // true

        Collection<Integer> collection5 = List.of(1, 2, 3, 1);
        System.out.println(CollectionUtils.containsDuplicate(collection5)); // true

        System.out.println();
    }
}