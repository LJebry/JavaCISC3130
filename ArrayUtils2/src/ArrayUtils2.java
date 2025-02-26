public class ArrayUtils2 {
    public static int[] copyOf(int[] arr) {
        int [] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            copy[i] = arr[i];
        }
        return copy;
    }

    public static int[] copyOf(int[] arr, int newLength) {
        int [] copy = new int[newLength];
        for (int i = 0; i < Math.min(arr.length, newLength); i++){
            copy[i] = arr[i];
        }
        return copy;
    }


    public static int[] copyOfRange(int[] arr, int from, int to) {
        int newLength = to - from;

        int [] newArr = new int[newLength];
        for (int i = 0; i < newLength; i++){
            newArr[i] = arr[from + i];
        }

        return newArr;
    }
}
