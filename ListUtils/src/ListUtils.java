import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtils {


    public static String getInitials(List<String> list) {

        String add = "";
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i).charAt(0);
            add = add + ch;
        }

        return add;
    }

    public static String swapFirstAndLast(List<String> list) {
        String last = list.get(list.size() - 1); // store last element index
        String first = list.get(0); // store first element index

        list.set(0, last); // replace fist element with last
        list.set(list.size() - 1, first); // replace last element first

        return list.toString();
    }

    public static List<Integer> firstN(List<Integer> list, int n) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n && i < list.size(); i++) {
            result.add(list.get(i));
        }
        return result;
    }

    public static List<Integer> lastN(List<Integer> list, int n) {

        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.clear();
            return result;
        } else {
            for (int i = list.size() - n; i < list.size(); i++) {
                result.add(list.get(i));
            }
            return result;
        }
    }

    public static boolean isSorted(List<Double> list) {


        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void printSorted(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy);


        for (int i = 0; i < copy.size(); i++){
            System.out.print(copy.get(i));
            if (i < copy.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
