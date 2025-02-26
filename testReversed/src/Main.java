import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(10, 5, 15, 25, 20));
        List<Integer> reverse = list.reversed();
        reverse.add(1, 7);
        reverse.remove(2);
        System.out.println(list);

    }
}