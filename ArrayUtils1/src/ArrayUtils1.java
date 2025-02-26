import java.util.Objects;

public class ArrayUtils1 {
    public static int indexOf(String[] a, String s) {
        for (int i = 0; i < a.length; i++) {
            if (s == null) {
                if (a[i] == null) return i;
            } else {
                if (s.equals(a[i])) return i;
            }
        }
        return -1; // If not found
    }


    public static boolean allEqualTo(String[] a, String s) {
        for (String element : a) {
            if (s == null) { //handle null
                if (element != null) return false;
            } else {
                if (!s.equals(element)) return false;
            }
        }
        return true;
    }


    public static boolean someEqualTo(String[] a, String s) {
        for (int i = 0; i < a.length; i++) {
            if (s == null) {
                if (a[i] == null) return true;
            } else {
                if (s.equals(a[i])) return true;
            }
        }
        return false;
    }


    public static boolean noneEqualTo(String[] a, String s) {
        for (String element : a) {
            if (s == null) { // null handling
                if (element == null) return false;
            } else {
                if (element.equals(s)) return false;
            }
        }
        return true;
    }


    public static boolean equals(String[] a1, String[] a2) {
        if (a1.length != a2.length) return false; // Different lengths
            //Compare each elements
            for (int i = 0; i < a1.length; i++) {
                if (a1[i] == null){
                    if (a2[i] != null) return false;
                } else {
                    if (!a1[i].equals(a2[i])) return false;
                }
            }
        return true;
    }
}
